# credit-card-api
credit card api for tower's technical assignment

For this assignment, I was not able to finish all of the required components due to lack of time.

1. Security
2. Integration Testing
3. Write more verbose api documentatoin for the customer

One more thing to note is that there is a validation error to do with LocalDate which is causing the appliation's post requets to fail. I wasn't able to fix this issue in time.

## Hind sight
1. I believe I have spent too much time on seraching for the correct regex patern. It would be good for me to learn more about regex sooner than later.
2. Too much time was spent on creating exceptions classes earlier on -> May have been better to foucs on MVP where I can get the actual application rolling first and use general exception in the mean time.
3. Some of my decisions were made to allow for long term scalability (e.g. Decision to create DTOs and Mappers) but I've used `String` for values for card numbers which aren't the most space efficient compared to numeric values.
4. Wasn't sure what to do with the limits on the card number. In NZ, we seem to use 16 numbers with 3 numbers for cvc number, but it wasn't mentioned in the assingment criteria (while name limit was). Have decided to go with
   not adding the character limit but it would have been better to just ask.
5. Forgot to add string trimmer to prevent unwanted empty spaces for our values.

If I were to do this again, I would have asked a bit more questions about the specifics, be more thoughtful about the time contraint and create more MVP product.
