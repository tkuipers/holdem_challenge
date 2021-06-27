# Texas HoldEm Challenge

This app reads a Texas HoldEm game state from STDIN and uses it to determine 
who is winning the game, it then prints that to the console.

##Pre-Requisites

In order to run this app you must have either Java 14, or Docker installed.

## How do I run it?

```shell
cat test.txt | ./run.sh
```

This app has two methods of execution, one using Docker and
one using Gradle.  There is a convenience run.sh script provided in the
main directory of the project.  You can pipe your input to that script, 
and the app will check to see if you have Java 14. If you do, it will
use Gradle to initialize the project and then pipe your input to the 'run'
task.  

If you do not have Java 14 installed, the app will fall back to
Docker.  It will pull the 'adoptopenjdk/openjdk14' image from Docker and 
will use that image to run the Gradle set up.  Your STDIN that was piped
into the script will be forwarded to the Docker container and used to 
evaluate the game state.

## How's it built?

<div style="width: 640px; height: 480px; margin: 10px; position: relative;"><iframe allowfullscreen frameborder="0" style="width:640px; height:480px" src="https://lucid.app/documents/embeddedchart/3c9a03dc-a698-4a0b-a27a-efbeed06f257" id="hQPP-28mwD7."></iframe></div>

Everything in this app starts in the ```main``` method of the 
```ArterysMain``` class.  This class creates the ```InputReader``` and the
```GameEvaluator```.  The ```InputReader``` interface specifies a couple
methods that are important to evaluating the game.  These methods are the:
1. ```String getCommunityString()```
1. ```List<String> getPlayers()```

Currently, the ```InputReader``` interface is implemented by the 
```StandardInputReader``` class, though this could easily be re-implemented to
read from files, or dbs, or some other medium should that become necessary.

The ```InputReader``` is passed to the ```GameEvaluator``` class.  This
class creates a ```CardParser``` and ```EvaluationEngine```.  

The ```CardParser``` class converts the output of the ```InputReader``` class into concrete game objects.
These game objects include both the ```Player``` construct, and the ```Card``` construct. 
The `Card` class contains information about the `Suit` and information about the value.
It also contains some utility functions for creation of new Card objects.

The `Player` objet contains information about the player, i.e. their name, their
private cards, and a reference to the community cards.  It also contains
a spot for a `HandValidation` class, which will contain their best possible hand
at the end of evaluation.

The `EvaluationEngine` is the heart of the hand identification system.
Through itself and the classes it calls, it determines the best possible hand
for each a player.  It receives a `Player` in its `evaluate` method and determines
the best possible hand for that `Player`.  It does so through a multi-step process.

1. Generate all 21 possible 5 card combinations for that player
1. Go through each of the `HandPreparers` listed in it's `validators` variable
to determine the highest possible value and ordering for any particular set of 5.
1. Keep track of the best hand possible in those 21 combinations through the use of the `HandValidationComparer`.
1. Return the best hand out of the combinations.

The `validators` variable within the `EvaluationEngine` contains a list
of `HandPreparers`.  They are stored in a list like this to make 
extending a little easier.  If this game were to start accepting another hand type,
you would only need to create another `HandPreparer` and another entry in
the `HandType` enum to add it.

Each of these `HandPreparers` is designed to identify
and prepare a hand.  They prepare hands by performing the following operations.

1. Identify the type of hand (i.e. 2 Pair, Royal Flush, etc).
1. Sort the hand according to the type.
    - We want to sort different hand types differently, a Straight needs to 
    be sorted from lowest to highest card.  A two-pair hand will need the pairs
    at the end of the hand, and the remaining cards stored at the beginning.
1. Store the results in a `HandValidation` class so that we can keep the hand state 
throughout the program.

After the hand is prepared, we need to determine how it 
it ranks among the other hands.  In this program, it is done
in the `HandValidationComparer` class.  This class takes in 2
HandValidations and determines which one is more valuable according 
to the game rules.  It does this by comparing the hands using the 
following priorities:

1. The Hand Type (eg. Royal Flush beats Straight Flush)
1. The In-Hand Values (eg. Pair Ace beats Pair Kings)*
1. The Out-Hand(Kicker) Values (eg. Pair Ace, King High beats Pair Ace, Ten High)

*The only exception to this is in a straight where an Ace is played low.  In
my implementation, this is handled in the `StraightHandPreparer`, when
we sort the cards into a useful ordering.  At this point it puts
the ace to the beginning of the list, which is where the low cards are.

After the hands are determined, the program does one final sort.  It 
sorts each of the player's best hand in relation to the other players. 
It is at this point, it also determines whether any particular kicker is relevant.
It does this through the `HandValidationComparer`.  If the 
`HandValidationComparer` is told to determine whether the kicker is
valuable, it will add necessary kickers to a set within the `HandValidation` object.
A kicker is determined to be worth adding if the `HandValidationComparer` gets to the "out of hand"
cards and one of those cards determines whether the hand is more valuable than the other.

After the ranking is decided, the program will then print the player name along with
their most valuable hand.  The method for determining what to print is stored
along with the hand type.  For Example, with a straight, you want to print the 
highest card, but with a two-pair hand, you want to print the names
of both the pairs.

It will then print whatever is in the kicker list for that hand and 
exit.




