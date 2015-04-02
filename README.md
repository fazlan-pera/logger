# logger
Logger is a portable java library which handles user registration within any java desktop application. If you are developing a standalone java application, and you need to handle user logins in a secure way, then "Logger" is your friend. All you have to do is, download the jar file and plug it to your own application. Since passwords are hashed and not stored in plaintext, you don't need to take any extra measure for the securing user passwords on your own.  



# How to use

You could easily integrate "Logger" in your personal java projects by following the guidelines below. 

      1) Download the logger.jar file with the matching version.
      2) Add this jar to your project's build path.
      3) Create a configuration.xml file with your database credentials and other settings.
      4) Make sure to set the entry point of your application to com.logger.ui.Login

# Sample configuration.xml file

  `<?xml version="1.0"?>`    <BR />
  `<DATABASE>` <BR />
	`<url>jdbc:mysql://localhost/test</url>` <BR />
	`<username>root</username>` <BR />
	`<table>users</table>` <BR />
	`<password>123</password>>` <BR />
	`<package>com.project.net</package>` <BR />
	`<MainUIClass>Welcome</MainUIClass>`<BR />
 `</DATABASE>`
  
  

   <br/>



Change configuration.xml file with your datbase credentials. <br /> <br/>
  **DATABASE** -- the root tag for database settings <br />
  **url** -- url of the database used  <br />
  **username** -- database username <br />
  **table** -- The name of the table where usernames and passwords will be stored in your application <br />
  **password** -- password for database <br />
  **package** -- Package of the entry point class of your application <br/>
  **MainUIClass** -- The class name of the entry point UI

# Features to be released

support for databases other than mysql.
