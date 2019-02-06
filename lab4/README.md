# **LAB 4**
----------

In this lab, we learn how to use GitHub and create multiple branches within a repository. Each branch would have thie rown commit which was then merged to the master.

We were also taught different git commands in the bash terminal to streamline our process for version control of our project.

----------

**Lab Participation Exercise (Git and GitHub)**

 1. As a team
  - Create a public github repository as a team with a new Android Studio project (1 project per team).
  - Add your members as collaborators so the whole team will be able to commit their branches.
  - The repository should include .gitignore to not include Android Studio settings files (.idea) and project build folder.
  - Create an abstract class Shape with x and y integer fields (as a team).
  - Commit the change and push it to github.
  
 2. As a member on our local machine
  - (Do not fork) Clone the repository and create a branch with your name (do not use CCID).
  - Create a model class (ex. circle, rectangle, star, etc) that extends Shape in your own branch.
  - Commit the change and push the branch to github.
  - Create a pull request to master in github.
  - Ask another member to merge it.
  - Edit Shape class by adding z integer field.
  - Commit the change.

 3. As a team
  - Edit Shape class in master branch in github by adding color string field.
  - Commit the change in github.

 4. As a member on our local machine
  - Pull the master branch from github. You should have a conflict.
  - Resolve the conflict.
  - Commit the change.
  - Push the branch to github.

 


[Click here to see the completed implementation](https://github.com/imtiazraqib/CMPUT301LPE4)