# Casino Simulation

* **Objective** - To create an casino simulation
* **Purpose** - To gain familiarity with general object orientation and design principles

* **Description**
    * View the [javadocs](https://zipcoder.github.io/casino.maven/docs/index.html) for the program to become better oriented with its design
      * `https://zipcoder.github.io/casino.maven/docs/index.html`
    * Create a casino simulation by extending or removing the pre-built implementations.
    * It is advised that you create additional methods and classes to mediate any foreseen shortcomings of the prebuilt assets. 
    * Enforce the following features in your system:
        * Ensure a console-based interface is available to allow input from and output to the users
        * Ensure the `Casino` has a selection of at least 6 implementation of `GameInterface`.
        * Ensure `PlayerInterface` is garbage collected upon completing a respective `GameInterface`
            * `SlotsPlayer` should be garbage collected when `SlotsGame` is garbage collected.
            * `BlackJackPlayer` should be garbage collected when `BlackJackGame` is garbage collected.
        * Ensure all implementation of `PlayerInterface` have reference to a `CasinoAccount`
            * `CasinoAccount` should not be garbage collected when a `GameInterface` is garbage collected.
        * Ensure at least 6 different implementations of `GameInterface` and a respective `PlayerInterface` are defined.
        * Ensure at least 1 implementation of `GameInterface` does not involve gambling.
        * Ensure at least 3 implementations of `GameInterface` involve gambling.
           * Enable the player to wager a `balance` that can be persisted throughout different games; when a `GameInterface` is garbage collected, the owner of the `balance` should be able to play a new game with their new `balance`.
        * Ensure all games which should support more than 1 player, have the ability to do so.
        * Ensure there are at least 80% line coverage from testing the application.
* Begin by implementing the `SlotsGame`, `SlotsPlayer` as well as `NumberGuessGame` and `NumberGuessPlayer` provided in the `com.github.zipcodewilmington.casino.games` package. 

<img src="./casino.gif">

## How to Download

#### Part 1 - Forking the Project
* To _fork_ the project, click the `Fork` button located at the top right of the project.


#### Part 2 - Navigating to _forked_ Repository
* Navigate to your github profile to find the _newly forked repository_.
* Copy the URL of the project to the clipboard.

#### Part 3 - Cloning _forked_ repository
* Clone the repository from **your account** into the `~/dev` directory.
  * if you do not have a `~/dev` directory, make one by executing the following command:
    * `mkdir ~/dev`
  * navigate to the `~/dev` directory by executing the following command:
    * `cd ~/dev`
  * clone the project by executing the following command:
    * `git clone https://github.com/MYUSERNAME/NAMEOFPROJECT`
 
#### Part 4 - Check Build
* Ensure that the tests run upon opening the project.
    * You should see `Tests Failed: ${number-of-tests} of ${number-of-tests} tests`
* Execute the command below to run JUnit tests from the command line. 
    * `mvn package -Dmaven.test.failure.ignore=true`








## How to Submit

#### Part 1 -  _Pushing_ local changes to remote repository
* from a _terminal_ navigate to the root directory of the _cloned_ project.
* from the root directory of the project, execute the following commands:
    * add all changes
      * `git add .`
    * commit changes to be pushed
      * `git commit -m 'I have added changes'`
    * push changes to your repository
      * `git push -u origin master`

#### Part 2 - Submitting assignment
* from the browser, navigate to the _forked_ project from **your** github account.
* click the `Pull Requests` tab.
* select `New Pull Request`
