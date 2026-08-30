# Part B 
1. In Sighting, make the fields private or protected and add getters. Then answer in ANSWERS.md: what did
   `private` buy you that Python's `_sightings` naming convention did not?

Java's access modifiers gain me defensive code where developers don't have to follow convention.
The fields are truly private or protected

2. FieldNotebook must compose its list, not inherit it. Then write two sentences on what would go wrong if
   FieldNotebook extends ArrayList<Sighting>. Be specific, name a method that would become available and
   should not be.

If FieldNotebook extends ArrayList<Sighting>, it would expose methods such as clear() or remove(), allowing outside code to directly erase sightings and bypass the behavior and restrictions that FieldNotebook is supposed to control.

3. Add a describeAll() method to FieldNotebook that loops over List<Sighting> calling describe(). One call
   site, three different outputs. In ANSWERS.md, name the mechanism that makes that work and explain where
   the decision is made (compile time or run time?).

This is compile time as java statistically types during compile. This is an example of composition and
delegation.

4. Add a second implementer of Describable that is not a Sighting — e.g. a WeatherNote. Add it to
   describeAll()'s handling without changing Sighting at all. This is the moment "program to an interface"
   stops being a slogan.

We Should Have programmed to the Describable interface for all things in FieldNote. By not doing this, we have couple FieldNotebook by Sightings,
and made it difficult to add the WeatherNote as another Observable.
 
   