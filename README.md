# Assignment1Soft

I have written project about university. When we execute the program, it asks who are you and depend on you answer, it shows required menu.

First of all, University class is realization of **Singleton Pattern**. Subjects are realization of **Strategy Pattern**. Teacher and Student classes are realization of **Observer Pattern**.
When we press:

## Press[0]:
Program finishes with exit code 1;

## Press[1]:
Program takes University instance, traverses students list and prints all of them.

## Press[2]:
Program depends on your choice(are you teacher or not), creates LocalLibrary object which connects with ExternalLibrary via **LibraryManagementAdapter**. if required book exists, local library borrows it,
if book doesn't exists, then via adapter it connects with external library and delivers book. If you are student, it check are you debtor or not.

## Press[3]:
Program depends on your choice(are you teacher or not), creates canteen(which is realization of **Factory Method**), if you want first meal, then initiates canteen as FirstMealFactory, etc. User enters his meal, then recieves it.

## Press[4]:
Program takes University instance, traverses teachers list and prints all of them.

## Press[5]:
Program takes all fields of student. And via **Decorator Pattern** wraps of information about student.

## Press[6]:
Program takes parametrs to create Student instance.

## Press[7]:
Program takes parametr(which subject to add), then chooses student and put grade randomly.

## Press[8]:
Program takes input of teacher's message and sends to all students. 
