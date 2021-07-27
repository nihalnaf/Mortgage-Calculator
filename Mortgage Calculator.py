#CONSTANTS
MONTHS_IN_YEARS = 12
PERCENT = 100

#Declare variables
principal = 0.0
monthly_rate = 0
years = 0
number_of_payments = 0

#While loop for user input for principal payment
while True:
  principal = float(input("Principal ($1K - $1M): "))
  if principal >= 1000 and principal <= 1000000:
    break;
  print("Enter a value between 1000 and 1000000: ")

#While loop for user input for annual interest rate
while True:
  annual_rate = float(input("Annual interest rate: "))
  if annual_rate >= 1 and annual_rate <= 30:
    monthly_rate = annual_rate / PERCENT / MONTHS_IN_YEARS
    break;
  print("Enter a value between 1 and 30: ")

#While loop for user input for period of years
while True:
  years = int(input("Period (Years): "))
  if years >= 1 and annual_rate <= 30:
    number_of_payments = years * MONTHS_IN_YEARS
    break;
  print("Enter a value between 1 and 30: ")

#Calculate mortgage
mortgage = principal * (monthly_rate * (1 + monthly_rate) ** number_of_payments) / ((1 + monthly_rate) ** number_of_payments - 1)
#Format mortgage as U.S currency
mortgage = "${:,.2f}".format(mortgage)
#Print the monthly payment
print("Mortgage: " + mortgage)
