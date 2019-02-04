# DT228/DT282 Object Oriented Programming 2018-2019

Resources
---------
* [The Java Tutorial from Oracle](http://docs.oracle.com/javase/tutorial/)
* [Games Fleadh](http://www.gamesfleadh.ie/)
* [The Nature of Code](http://natureofcode.com/)
* [The git manual - read the first three chapters](http://git-scm.com/documentation)
* [A video tutorial all about git/github](https://www.youtube.com/watch?v=p_PGUltnB6w)
* [The Processing language reference](http://processing.org/reference/)
* [Introduction to Maven](https://maven.apache.org/guides/getting-started/index.html)

## Contact the lecturer
* Email: bryan.duggan@dit.ie
* Twitter: [@skooter500](http://twitter.com/skooter500)

# Assessments

- [Assignments](assignments.md)

- Week 11 Lab Test 20% 
- Week 12 Assignment Submission - 30%
- End of Year exam - 50%

# Week 2 - Variables, loops, Processing

- []

# Week 1 - Introduction

- [Dogs & Cats example](java/src/ie/dit)

Some assignments from previous years:

[![YouTube](http://img.youtube.com/vi/ENDHavHsL2k/0.jpg)](https://www.youtube.com/watch?v=ENDHavHsL2k)

[![YouTube](http://img.youtube.com/vi/zLXon_nlibY/0.jpg)](https://www.youtube.com/watch?v=zLXon_nlibY)

[![YouTube](http://img.youtube.com/vi/vecMCz1eB1s/0.jpg)](https://www.youtube.com/watch?v=vecMCz1eB1s)

[![YouTube](http://img.youtube.com/vi/xlEudfLH6Fg/0.jpg)](https://www.youtube.com/watch?v=xlEudfLH6Fg)

[![YouTube](http://img.youtube.com/vi/uykz5mCjV0w/0.jpg)](https://www.youtube.com/watch?v=uykz5mCjV0w)

[![YouTube](http://img.youtube.com/vi/sPjZSRCmt1U/0.jpg)](https://www.youtube.com/watch?v=sPjZSRCmt1U)

# Lab 1
## Learning outcomes
- Use git
- Make your first Java classes


### Part 1
Create an account for yourself on [github](http://github.com). Sign up for the [github student pack](https://education.github.com/pack) to enable you to create private repositories.

### Part 2

Create a new empty folder using Windows Explorer and then right click on the folder and choose git bash here. Alternatively you can start the bash and cd to the new folder. To clone the repository for the course to the empty folder type:

```bash
git clone https://github.com/skooter500/OOP-2018-2019
cd OOP-2018-2019
```

Now lets create a branch to store your work for today. Type:

```bash
git checkout -b lab1
```

All your changes from now on will be on this branch rather than the master branch. 

Type 

```bash
ls
```

And you will see the folder OOP-2018-2019 has been created. Type:

```bash
cd OOP-2018-2019/java
```

Make a folder called bin by typing:

```bash
mkdir bin
```

This is where the java compiler will place generated .class files compiled from the Java source files in the src folder. The bin folder and compiled class files will not be in the git repo as it just stores source code and not the output of the build process. To compile, type:

```bash
javac -d bin src/ie/dit/*.java
```

To run your program type:

```bash
java -cp bin ie.dit.HelloWorld
````

You should see:

```
Hello world
Misty
Woof!
Meow!
Felix
```

Appear on the console. Congratulations! You compiled and ran your first Java program. 

Now open up the Java code files in Notepad++ or Visual Studio code if you are using your own computer. Modify the Cat class:

- Add a private field for numLives of type int on the Cat class
- Make accessors (set and get methods) for numLives, similar to how this was done in the Dog class
- Write a default public Constructor for the cat that sets the number of lives to be 1. A default constructor is a method with the following characteristics:
    - No return type!
    - Same name as the class
    - Takes no parameters
    - Gets called when the object is created 
- Write a method on the Cat class called kill. It should subtract 1 from numLives if numLives is > 0 and print the message "Ouch!". If numLives is 0, you should just print the message "Dead"
- In the Main class, construct a Cat instance and in a loop, call kill until the Cat is dead.

Commit your changes to the branch by typing:

```bash
git add .
git commit -m "Added kill method to the Cat class"
```

Switch back to the master branch by typing:

```bash
git checkout master
```

Notepad++ will reload your files and you will see that your changes are gone.

Change back to the lab1 branch by typing:

```
git checkout lab1
```

And you will find your changes there

### Part 3

- Clone the repo for the course last year. The URL is https://github.com/skooter500/OOP-2017-2018
- cd into the java folder of the newly cloned repository
- To compile the code, type:

```
./compile.sh
```

- To run the code type:

```
./run.sh
```

If you edit the file Main.java, you can comment out the line main.matrixMultiplication(); and instead uncomment any of the other lines to see some of the examples we made last year. In particular, the tuineFinder1 example is pretty cool. It loads up a recording of a tune played on the tinwhistle, transcribes the audio to music notes and then finds a match for the tune in an SQLite database of tunes

```Java
//main.matrixMultiplication();
//main.editDistance();
//main.strings();
//main.dictionary();
//main.transform();

main.matrixMultiplication();
//main.tuneFinder1();
```


