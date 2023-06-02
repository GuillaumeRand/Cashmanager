Project Construction
• embrace classical design patterns
• implement a Project Object Model, like Maven
• build a code coverage thanks to Unit Tests
• provide extensive functional and technical documentation
Project modeling is the basis of a development cycle. It handles the various steps of the
making of a program, in a way that can easily be handled to another programmer on
another device.


Specifications

In this project you have to make a mobile app, which will be your terminal. Users will use the terminal by querying the server. Your terminal is supposed to let you add articles to a cart, then proceed to payment. The terminal must provide a way to configure the network location and the password of the server with a setting view. The payment process must allow credit card and cheque payment. Before any payment, the terminal must be connected to the payment server, then scanning can proceed and finally payment attempts. The pay- ment server can allow or refuse the payment, for instance if security codes do not match. You must be compliant with the material which is composed of four screens: • a setting screen allowing the user to connect the terminal to the server (including login/password input fields) • a screen displaying the cash register, where the user adds articles and the bill is updated in real time • a screen displaying the bill’s total (no specific action but proceed to payment) • a screen providing the user payment. It allows the user to scan a card (NFC Reader) or a cheque (QR Code scanner) and displays the card payment status: pending authorization, payment accepted, payment refused.

On the other side, you are expected to build a server application that will handle requests from the terminal. This application will: • receive requests • accept or refuse authentication based on stored data (any authentication method will do) • fetch data from the bank account (any storage method will do) • accept or refuse the payment, based on credit card/check information and money reserves 4 • notify the mobile app in return • update the user’s account according to the transaction

Bonuses You can improve this project in many ways, including: • adding a real authentication protocol with security checks • building an admin view for the server (either directly with a java graphical lib or as additional features for the android app that are available only for admin people) • conduct a full functional testing process through an external platform according to tour qualification specs • adding formal specification documents, including various uml diagrams


