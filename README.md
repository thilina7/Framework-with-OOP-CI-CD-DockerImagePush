# Project installation guide

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project contains the framework written using java OOP concepts to automate login feature of pipedrive.
	
## Technologies
Project is created with:
* java version: jdk1.8.0_221
* Selenium WebdriverManager version: 4.4.3
* TestNG version: 6.1.1
	
## Setup
To run this project, Need to follow below instructions:

#### Step 1: Download and install java,eclipse on your PC.
1. Download and install JDK (optional if java is not installed on the machine) 
2. install Eclipse IDE (https://www.eclipse.org/downloads/)
3. Open the downloaded file and select ‘Eclipse IDE For Enterprise Java and Web Developers’ from the pop-up.
4. Choose the installation folder and press the ‘INSTALL’ button.
5. Lastly, click on the ‘LUNCH’ button.

#### Step 2: Clone the github project
1. Open “Git Bash” or cmd.
2. Type git clone in the terminal, paste the URL you copied earlier, and press “enter” to create your local clone. (ex: git clone https://github.com/thilina7/Framework-with-OOP-CI-CD-DockerImagePush.git)

#### Step 3: Setup the project in eclipse
1. In Eclipse, select File > Import…
2. In the import window, expand Maven, select Existing Maven Projects, and click Next
3. Click Browse, and select the directory that contains the pom.xml file of the cloned project.
4. Click Finish. Eclipse will import the project and start downloading the required resources.
5. Setting up the project in eclipse will take awile.

#### Step 4: Install TestNG to the eclipse
1. Click on Help and then Eclipse Marketplace.
2. A new window would open up, wherein you need to type “TestNG” in the Find text box and click on the Go button.
3. You will now see the search results with TestNG for Eclipse at the top. All you need to do now is click on the Install button next to it.
4. Resolving of features might take up a few minutes after which you need to verify that the checkbox for TestNG is checked and click on the Confirm button.
5. Select “Keep my installation the same” option and again click on the Confirm button.
6. Accept the license and click on the Finish button.

Note: For the change to be effective, you will have to restart Eclipse and you will now be able to see TestNG installed by right-clicking on any project and seeing TestNG in the menu options.

#### Step 5: Run the "Framework-with-OOP-CI-CD-DockerImagePush project"
1. Double click on the TestNG.xml file on the left Framework-with-OOP-CI-CD-DockerImagePush project tree
2. Right click on the file and navigate to Run As >> TestNG Test
3. Then you will see project start running.
4. Go to "Result of running suite" tab and check the TestNG report result once script finish running.
