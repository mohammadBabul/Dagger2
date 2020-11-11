# Android Dependency Injection(DI)

* Dagger2
* Java
* SharedPreferences



Here is the example of Dependency injection(DI) in android.

Just Imagine the following secenario that We have an Activity and we wish to save some data in the SharedPreferences. Doing this without DI we should instantiate Sharepreferences for saving, retrieving data from the SharedPreferences,  If we want to use those edit, update or get those data in other activity, we must have to pass the context. For avoiding frequent instance creation we use DI. 

### Why use Android Dependency Injection?
If you’re the boss of a company, would you prefer doing all the things yourself or delegate the tasks?

Would you prefer hiring a nobish over an expert who already knows the task?

In an ideal situation, the answer to both of the above questions should be the second option.

That’s why Dependency Injection is so critical. Instead of instantiating SharedPreferences, Databases, Network Libraries in our Activity each time, we’ll prefer to have instances of them created somewhere else and inject them in our Activity when it’s needed.


For more details about dagger (https://medium.com/@babul.sust.cse/about-dagger-13549d064552)
