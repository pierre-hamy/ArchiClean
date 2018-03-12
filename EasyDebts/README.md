# Easy Debts

You are going on a road trip with your friends.
There are 4 of you in a rental car : Alice, Bob, Claire and David.
You are making a road trip in Ireland because you like stout and sheeps.

You don't really know how long you'll stay there, nor the price of gas or affordable BnB availabilities, so you just can't draft a budget for this trip.
You decided with your friends it would be easier that each one would pay some stuff everyday and to sort out who owes money to who once you are back home.


## Features

Examples are given in pseudo-code.


### Registering a payment

+ Alice paid an irish coffee for herself, Bob and Claire (but not David). The bill amount was 15 €.
```
payment_history.register_payment(15, 'Alice', ['Alice', 'Bob', 'Claire'])
```

+ David paid a pint of guinness for Alice and Claire (but not himself nor Bob). The bill amount was 8 €.
```
payment_history.register_payment(8, 'David', ['Alice', 'Claire'])
```

+ Bob paid lunch for everyone (primarily burgers). The bill amount was 32 €.
```
payment_history.register_payment(32, 'Bob', ['Alice', 'Bob', 'Claire', 'David'])
```


## Balance debts

Rather than a very detailed list of debts, the simplified balance is computed by the software.

```
payment_history.balance_debts()
"
  Alice owes 2 € to Bob
  Bob has no debts.
  Claire owes 17 € to Bob
  David has no debts.
"
```
