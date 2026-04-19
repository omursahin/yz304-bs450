# Control Flow Graphs (CFGs)

1) Recall the
   [`Triangle`](../../apps/src/main/java/eru/testing/Triangle.java)
   example. Draw the control flow graph (CFG) for the `classify` method. 
   
   One thing we did not consider in lectures is what happens, control flow-wise,
   when an exception is thrown. Include what you think is the control flow when
   an exception is throw in your graph.

2) Recall the
   [`Calculator`](../../apps/src/main/java/eru/testing/calculator/Calculator.java)
   example. Draw the class control flow graph (CCFG) for this class. Label nodes
   with their respective definitions and uses. 
   
   When a method calls a method in the same class, you can simply represent this
   as a regular node inside the calling method, rather than drawing arrows to
   the body of that method in the CCFG. 
   
   We did not consider control flow in lectures when exceptions are thrown and
   caught in `try`-`catch` structures. What do you think is the control flow
   here?
