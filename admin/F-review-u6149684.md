Reviewer: Yen-Wei, Li (u6149684)
Component: <Task 6 from Line from Line 212-276 in StepGame class>
Author: Shashank Chetlur Chary (u6352431)

Review Comments:

1. StepGame.java:Line 253-255, new method 'checkifPieceValid' is being created, but the order of the new String for sequence method is incorrect, 
   which is placement+piece, but it should be piece+placement. Other than that this method looks good.
2. StepGame.java:Line 256-261, 'convertFromStringToPieces' this method is well designed and produced excepted output. 
3. Overall, the code he wrote for Task 6 is well design with proper name to all variables and methods. The best feature 
   of the methods he created is he make used of some useful tested methods from the previous task, which make the code easier 
   to debug and read. However, currently, the code can only passed 1 test, so it would be better if he make some changes 
   to the code so it can pass all the tests and have expected outcome.