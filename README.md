eNav-api
========

A model and a service catalog for e-navigation:

The project consists of 3 main parts.
<ol>
  <li>enav-model:     A model of the maritime domain (still under development).</li>
  <li>enav-messages:  A small framework for sending messages between different peers.</li>
  <li>enav-services:  A number of e-Navigation services.</li>
  <li>enav-util:      Various utility classes.</li>
</ol>

eNav-model
==========
The eNav-model sub-project is a conceptual model of many of the common topics in the maritime domain.
It describes the various entities, their attribtues, roles and relationships.
The main purpose of the model is to represent the vocabulary and key concepts of the maritime domain. 
The domain model provides a structural view of the maritime domain that can be complemented by other dynamic views, 
such as the eNav-services subproject.

An important advantage of the model we have developed is that it describes and constrains the scope of the maritime domain. 
We believe it can be effectively used to verify and validate the understanding of the maritime domain among 
various stakeholders. Furthermore it defines the vocabulary and can be helpful as a communication tool. 
It can also add precision and focus the discussion among business users as well as between the technical and business team.

eNav-messages
=============
We suggest an archicture in which various agents (such as ships, VTS centers or lighthouses) communicate with each others
by exchanging a number of predifined messages.
Essentially, a message is a structured piece of information sent from one agent to another over a communication channel.
Some messages are requests made to one agent by another, other messages deliver data or notification to another agent.
In most applications that we'll discuss, a message consists of a message identifier and, 
if needed, a set of message arguments. The message identifier tells the receiver the purpose or type of the message. 
The arguments to the message contain additional information that is interpreted based on the type of message. 

Describe howto
<ol>
<li>MaritimeMessage can both be a logical or physical message (or both such as ais)</li>
</ol>


eNav-services
=============
eNav-services contains some of the services we suggest for the eNavigation service portfolio.

eNav-util
=============
Various utilities
