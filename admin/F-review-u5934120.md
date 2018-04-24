Reviewer: PENG YONG (u5934120)
Component: <Task 4>
Author: Yen-Wei, Li (u6149684)

Review Comments:
The previous code has a unique feature. Two Group root have been created. It is clear but still some problems here and I have edited
and committed the code. The code is well-documented, for each steps, here are some explanation to show what the code to do.The program
decomposition is not very good. For the node Group defined in the task, the event handling was used in the task but it was redundant.
For every time refresh, only the placement and input picture should be clear. However, in the code, the operation is redundant because
the author clear the root that contains board, which is unnecessary. Therefore, I edit the code and put the image into the Group control
and board into Group root and every refresh, only the image is refreshed and all the other things are remain the same. Besides, the code
that adding imaging can be simplified. I put the String and relevant integer to map and get them out one by one and add together.
I have edited the code and committed. Also, the code that never used is deleted. This style of naming is kept consistent throughout the code.