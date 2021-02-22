# Simple demo trade-service Spring Boot + Postgres application	
# BUSINESS SERVICE REQUIREMENTS:
- value date cannot be before trade date
- value date cannot fall on weekend or non-working day for currency
- if the counterparty is one of the supported ones
- validate currencies if they are valid ISO codes (ISO 4217)							
  SPOT, FORWARD:
- validate the value date against the product type							
  OPTIONS SPECIFIC:
- the style can be either American or European.
- American option style will have in addition the excerciseStartDate, which has to be after the trade date 
  but before the expiry date.
- expiry date and premium date shall be before delivery date.
# The validation response should include information about errors detected in the trade 
(in case multiple are detected, all of them should be returned) and in case of bulk validation additional 
linkage between the error and the actual trade.							
   ASSUMPTIONS:
- Current date is 18.07.2017
- Supported counterparties (customers) are: PLUTO1, PLUTO2
- Only one legal entity is used: CS Zurich							

