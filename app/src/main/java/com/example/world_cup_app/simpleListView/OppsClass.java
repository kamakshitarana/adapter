package com.example.world_cup_app.simpleListView;

public class OppsClass {


    public static void main(String[] args) {
        //Methods---> methods is block of code which only runs when its called
        sayHello();

        //methods parameter ---> method parameters we pass under the () when we define it we have to pass the parameter value aswell
        paremeters("kamakshi");

        //method overloading ---> with this multiple methods have same name with different parameters
        double c=addTwoNumber(3.5,5.6);
        System.out.println(c);

        //classes and objects----> Everthing in java is associated by objects along with its attributes and objects

        //Attributes
        // public int numbers =2023;

        /** Constructor--> A Constructor in java is a speacial methods that is used for initial the objects
                          the constructor is called when a object of class is created it can be used for to set the object initial value
                          constructor and java class name is same if u will not create a class same as a constructor then java will create a automatically.
         **/

      /**Modifiers --> the public keyword is an access modifires ,
       * meaning that,
       * it is used to set the access level for classes, attributes ,methods
       * and constructors.
       *
       * We divide modifires into two groups:
       * Access Modifires ---> controls the access level
       * Non Access Modifires --->do not control access level but provides other functionality.
       *
      **/

      //For Claasess--> public--->it is accessiable for other aswell
                       //default
                        //ex-->   class OppsClass { }  ,here i removed the public so its default
                            //default means the class is accessiable for by classes in the same package.

        /**Access Modifireas
         *for Attributes----> methods and constructors : public ,private,default,protected
         * protected --->the code is Accessiable for in same package and in subclasses
         **/

        //final ---> if we make and attributes to as a final then if we tries to chng it value we can not change,

        //Diff  between public and static method
        //for access to public method we need to create a object and static mehod we can access directly without creating an object.


        /**Non-Access-Modifires
         *
         * For Classes--final or abstract
         *For Attributes,methods---final,static,abstract,transient,synchronized,volatile
         * **/


        /**
         *ENCAPSULATION==== getter and setter is encapsulation.(and outside class can not access it when attribute is private so we create getter and setter for this )
         * hidden data from the user to achieve this you must have declare class
         * variables/attributes as private public and get and set methods to access
         * and update the value of private variable.
         *
         * **/

        /**INHERITANCE===
         *In java it is possible to inherit attributes and methods from one class to another
         * we group the inheritance concept into two categories subclass or the child.
         *
         *(so in java inheritance is a relationship)
         * **/

        //-->Case-1:
        /**Vehicle class is a parent class **/
//        public class Vehicle{
//            public void horn(){
//                System.out.println("peep ,peep");
//            }
//        }

        /**Car class is a child class here we extend the vehicle **/
        //-->Case-2:
//        public class Car extends Vehicle{
//            private int Weight;
//            private String color;
//
//        }

        //-->Case-3:
//        Public static void main (String[] args){
//            Car mercedes =new Car(1233,"Red")
//        }


        /**POLYMORPHISM
         * polymorphism means many forms and it occurs when we have many classes and
         * they are related to each other by inheritance like we specified in the previos values.
         * **/
        //EXAMPLE--
        //case-1  Parent class
//        public class Animal{
//            public void animalSound(){
//                System.out.println("the animal makes the sound ");
//            }
//        }


        //case-2 ---child of the Animal class
//        public class Cat extends  Animal{
//            @Override
//            public void animalSound() {
////                super.animalSound();
//                System.out.println("the cat says meow");
//            }
//        }

        //case3  child of the Animal class
//        public class Dog extends  Animal{
//            @Override
//            public void animalSound() {
////                super.animalSound();
//                System.out.println("the dog says BOw");
//            }
//        }

//        Animal myDog1 =new Dog();  //THIS IS EQUAL TO THIS ONE--->Dog dog1 =new Dog();
//        Animal cat1 =new Cat();
        //so here POLYMORPHISM make animal is had is having or has many forms inside this projects
        //(So its useful for code, reusability ,reuse,attributes and methods of existing class when you create)




        /**ABSTRACTION
         * Data abstraction is the process of hiding certain details and showing only
         * essential information to the user abstraction can be achieved by either abstract classes or interfaces.
         *the abstract keyboard is non-access modifier and used  for the classes and methods.
         * **/
          //Example
        //step1
//        abstract class Animal{
//            public abstract void animalSound();  //when for all the property sound propery is diff diff so used abstract
//            public void sleep(){                 //whn all the property is same for all the animal used public
//                System.out.println("zzzz");
//            }
//        }
//
//        //step2
//        public class Cat Extends Animal{
//            @Override
//            public void animalSound(){
//                System.out.println("meow");
//            }
//
//        }
//
//        public class Dog Extends Animal{
//            @Override
//            public void animalSound(){
//                System.out.println("Bow");
//            }
//        }


        //we can achieve the abstraction via interfaces.
        //(FOR INTERFACE WE USED IMPLEMENTATION )


        /** Packages are divided into two categories:
         *
         * Built-in-Packages(Packages from the Java Api)
         * User defined Packages(create your own packages)
         *
         * **/






    }

    private static int  addTwoNumber(int x,int y) {
      return x+y;
    }
    private static double  addTwoNumber(double x,double y) {
        return x+y;
    }

    private static void paremeters(String name) {
        System.out.println("my name is :" +name);
    }

    private static void sayHello() {
        System.out.println("hii");
    }

}
