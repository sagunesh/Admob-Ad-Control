# Admob Dynamic Ad Control using Firebase

Developed a Solution for Managing your admob CTR, updating  adcode on the go without updating the apps dynamically and prevent click fraud for your Android Application from malicious third party clicks

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See installation notes on how to deploy the project on a live system.

### Prerequisites

Android Studio(Minimum Requirements)
	
```
1)64-bit distribution capable of running 32-bit applications
2)3 GB RAM minimum, 8 GB RAM recommended; plus 1 GB for the Android Emulator
3)2 GB of available disk space minimum, 4 GB Recommended (500 MB for IDE + 1.5 GB for Android SDK and emulator system image)
4)1440x900 minimum screen resolution for effective work.

```

### Installation

Here is the step by step series of examples that tell you have to get a development env running

* Download whole project.
* Open android studio.
* Click on import project and import the downloaded project
* Once importing is finished
* Rename the package name.
* Visit google [Firebase](https://console.firebase.google.com) 
* SignIn with your google account
* Click on  Add Project Button and Create project
* On next screen select android as project and type your package name that you  used to rename the orignal package name like 
```
Eg com.saguneshgrover.admob
```
* To genertae a signing certificate SHA-1 just go to your android studio on extreme top right below close option  there is an option named Gradle click on that
```
->A right sidebar will be opened
->click on admob
->click on admob(root)
->click on Run Configurations and click on admob[signingReport]
->Below admob signing report is generated with your SHA1 signing certificate

```
* Just copy that and paste it in your Debug signing certificate SHA-1 field on firebase console
* Then after that a config file will be downloaded named as google-services.json
* Just download that file and import that file in your (project/app) folder
* Now lets have a look at Database structure
* In this way  Data is Stored – JSON Structured on firebase console

```
{
  
  "demo" : {
    
		"badd" : "Your Banner adcode",
    
		"iadd" : "Your Interstitial adcode"
  
	   }

}

```

* You can import this file from db folder that is  in the project folder
* Also note change the database rules to this 
* Note These are defined public means anyone can read or write to your db you can configure according to your own needs For more details read this [Security and Rules Guide](https://firebase.google.com/docs/database/security/) 
```
{
  "rules": {
    ".read": true,
    ".write": true
  }
}
```

Thats it now you can run the app successfully

## Running the App

Hit the run or Shift+F10 shortcut key to  run the app select the appropriate device to run the app now you are ready to go 

## Built With

* [FireBase](https://firebase.google.com/docs/database/) - The Real Time Database
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Sagunesh Grover** - *Initial work* - [Click this to  Visit My Website](http://www.saguneshgrover.com)


## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/sagunesh/Admob-Ad-Control/blob/master/LICENSE) file for details

## Acknowledgments

* I developed this demo so that developers can change their adcode dynamically in their android apps like we can do with our websites instead of pushing a new update on playstore
