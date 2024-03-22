Requirements:

Java Development Kit (JDK) installed on your system.
A Java IDE or text editor to view and edit the source code.
Basic understanding of Java socket programming.
File Structure:

ChatServer.java: Contains the implementation of the server component.
ChatClient.java: Contains the implementation of the client component.
How to Run:

Compile the source files using the Java compiler.

bash
Copy code
javac ChatServer.java
javac ChatClient.java
Start the server by running ChatServer.

bash
Copy code
java ChatServer
Start one or more client instances by running ChatClient.

bash
Copy code
java ChatClient
You can run multiple instances of ChatClient to simulate multiple users chatting.

Usage:

After running the server and connecting client instances, users can send messages by typing them into the console and pressing Enter.
Messages sent by one client are broadcasted to all connected clients, allowing for group chat functionality.
The client application continuously listens for incoming messages from the server and displays them in the console.
Troubleshooting:

If you encounter a java.net.BindException: Address already in use: bind error, it means the specified port is already in use by another process. Refer to the Troubleshooting section in this README for solutions.
Additional Notes:

This chat application provides a basic implementation and does not include features like user authentication, message logging, or graphical user interface (GUI).
Feel free to extend the functionality of the application according to your requirements or experiment with different features.
Contributors:

This codebase was created by [John Paul Balmaceda] as part of a programming assignment or personal project.
License:
ls.
Feedback:

If you have any feedback, suggestions, or encounter any issues with the application, please feel free to contact [Your Email] or open an issue on the GitHub repository.
Acknowledgements:

Special thanks to 
Mopelola Akinyem for their support and guidance for the creation of this chat application.
References:

Pankaj. (2022, August 4). Java socket programming – Socket server, client example. DigitalOcean.  https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client
Eck, D. J. (2022). Introduction to programming using java version 9, JavaFX edition. Licensed under CC 4.0. https://math.hws.edu/javanotes/

Bondar, S. (2023, April 18). Java file handling: Reading and writing text and binary files. REINTECH. https://reintech.io/blog/java-file-handling-reading-writing-text-binary-files
Version History:

Version 1.0: Initial release (03/21/2024)
