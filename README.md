<h1 align='center'>Assigmment 2, SDJ2 <br> (MVVM, Observer, Sockets) </h1>

<h3>The assignment:</h3>
<p>
You must design and implement a simple client/server application as a chat system with multiple clients.
</p>

<h3>Requirements: </h3>
<p>
 - The application must use Sockets connecting client and server, with the server being multithreaded <br>
 - The client must be able to: <br>
&nbsp; &nbsp; 1. send messages <br>
&nbsp; &nbsp; 2. receive messages broadcasted (multicasted) to all clients <br>
&nbsp; &nbsp; 3. request an information from the server, e.g. number of connected chatters, list of connected chatters or similar. (This information will not be broadcasted to other clients) <br>
 - You must use MVVM with at least two windows. Some ideas: <br>
 &nbsp; &nbsp; o Actual chat window <br>
 &nbsp; &nbsp; o Set username / alias window <br>
 &nbsp; &nbsp; o List of friends window <br>
 &nbsp; &nbsp; o Login window <br>
 - You must use the Observer design pattern as part of the solution. <br>
 - You must use either Singleton or Multiton as a log to the server console and to file(s). It should always be possible to find all the communication for an entire day –text, IP address, date and time <br>
 - It is required to make a class diagram for the full solution (in Astah). In the diagram you must be able to identify the MVVM, the Observer pattern and the design of the socket related classes <br>
</p>

