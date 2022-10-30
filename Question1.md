# Use Cases
![image](https://user-images.githubusercontent.com/95394109/198855958-32ce54ab-1321-4837-8ae5-074abd718068.png)


| Use Case | Description | Requirement |
| -------- | ----------- | ----------- |
| UC-1: Start product purchasing session | The cashier starts the product purchasing session through their keyboard before scanning any items or enter any barcodes. | R-01 |
| UC-2: Cancel session | The cashier cancels the product purchasing session at any time before the session ends. If there have been products scanned or barcodes entered since the start of the session, all these products are now nullified. | R-02 |
| UC-3: Scan item | The cashier scans the barcode on items to display its name and price on the display. This information is pulled from a local database. | R-03 |
| UC-4: Manually enter barcode | For items whose barcode cannot be read by the scanner, a message will appear on the screen saying "Unknown product". The cashier then manually enters the barcode for the item through the keyboard. | R-04 |
| UC-5: View product info | All product info, including name, price, quantity, and total price, are viewable on the display and printed on the paper ticket receipt at the end of the session. | R-03, R-06 |
| UC-6: Select a payment option | After scanning all products, the cashier selects a payment option such as cash, credit, or debit through the keyboard. If credit or debit is selected, a 3rd party payment system is used to complete the payment. | R-05 |
| UC-7: Cancel product purchase | The cashier cancels any product that has been scanned or entered during the session by selecting the product cancel option on the keyboard and either scanning the item or manually entering its barcode. | R-07 |
| UC-8: End product purchasing session | After successful payment, the cashier ends the product purchasing session. A list of all products, the unit price, quantity, and total price are printed on a paper ticket receipt. | R-06 |
<br>

# Quality Scenarios
| ID | Quality Attribtue | Scenario | Associated Use Case |
| -- | ----------------- | -------- | -------- |
| QA-1 | Modifiability | Any part of the hardware of the cash register, including the whole platform, can be easily changed in the future. | All |
| QA-2 | Security | The payment of products should be done securely without the risk of leaking credit or debit information. | UC-6 |
| QA-3 | Availability | The cash register system should not be down for longer than 1 minute. The local database should remain available 24/7. | All |
| QA-4 | Usability | The system should have clear labels for all its functions so that any new cashier can eaily learn how to use it with minimal errors. | All |
| QA-5 | Performance | After scanning an item, its information should be on the display within 3 seconds. For items whose barcode cannot be found, the message "Unknown product" should also be displayed within 3 seconds of scanning. | UC-3, UC-4 |
| QA-6 | Performance, availability | After ending the session, all items scanned and their quantites should be removed from the count in the local database within 5 seconds to prevent inventory errors. | UC-8 |
| QA-7 | Interoperability | The cash register should be able to easily communicate with the 3rd party payment system to complete transactions. | UC-6 |
<br>

# Contraints
| ID | Constraint | Requirement |
| -------- | ----------- | ----------- |
| Con-1 | x | R-0x |
