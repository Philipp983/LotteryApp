# LotteryApp
App to generate lottery ticket numbers for either 6aus49 or Eurojackpot. 

The program is to be used through command line arguments.
You can either choose 6aus49 or Eurojackpot.
Additionally, up to 6 unlucky numbers can be passed to the program, 
which will then be excluded from the generated lottery tickets.
Note that if numbers are passed, they will be saved for future use until deleted. 
E.g.:
- 6aus49 (will generate a lottery tickets with 6 numbers, ranging from 1 to 49)
- Eurojackpot 2 15 44 (will generate a lottery ticket with 5 numbers, ranging from 1 to 50, plus two numbers from 1 to 10)

Note: the range of acceptable numbers for 6aus49 is 1 to 49, while for Eurojackpot it is 1 to 50.
For incorrect number entries (out of range, too many numbers), a message will be displayed.
If a parameter is not recognized, the program will display the available commands.

Additional commands:
- setunluckynumbers (+ up to 6 numbers that have to be specified) - to set a new set of unlucky numbers.
E.g.: 
- setunluckynumbers 1 15 33

- showunluckynumbers - shows the current set of unlucky numbers.

- clearunluckynumbers - clears the current set of unlucky numbers.

- unlimitedlotto + lottery type (+ optionally up to 6 numbers) - generates lottery tickets for the specified lottery type until 'Enter' is pressed.
E.g.:
- unlimitedlotto Eurojackpot 2 50


The unlucky numbers will be saved in a file 'unlucky-numbers.txt' and events occurring in the program saved to a log file 'logs'.
