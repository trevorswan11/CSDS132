Reflection:

  Java reflection is a way to look inside the structure of an object or a class even if we do not have access to the source code.
  We can also use reflection to manipulate any object or class.

  	Object obj = new JFrame();
  	Class<?> cls = obj.getClass();       

  cls now stores the class information about the JFrame class.  (Note we could have created the JFrame object using just reflection, too!)
  We can get a list of all non-private methods of the JFrame class:

	cls.getMethods();

  or all the methods (including the private ones) declared in the JFrame class:

	cls.getDeclaredMethods();

  We can get a specific method.  For example, the getTitle method.  It has no parameters.  The declaration is
	`public Method getMethod(String name, Class<?>... parameters)`
  Rembember that the ... is shorthand for an array.  We can either pass in an array, or we can pass in the individual elements of the array.

  So, there are two ways we can retrieve the getTitle method:

	Method m = cls.getMethod("getTitle", new Class[0]);
  or
	Method m = cls.getMethod("getTitle");

  We can call the method to get the title of the JFrame using the invoke method of Method.  The invoke method takes both the object we are running the method on as well as the inputs to the method.

	m.invoke(obj, new Object[0]);
  or
	m.invoke(obj)

  Remember that obj is the JFrame object.  This states that we are calling the method stored in m on the object obj using the given parameters.

  Now, let us try the setTitle method.  This takes a single String.  We can easily get the String class using the same technique we got the JFrame class.

	m = cls.getMethod("setTitle", new Class[]{"Hi".getClass()});
  or
	m = cls.getMethod("setTitle", "Hi".getClass());
  or use a field type notation
	m = cls.getMethod("setTitle". String.class);

  To call it:
	m.invoke(obj, new Object[]{"The Window Title"});
  or
	m.invoke(obj, "The Window Title");

  Now, try the setVisible method.  This takes a boolean, but boolean is not a class, it is a primitive!  Java has a special field with each wrapper class that gives the
    appropriate value to indicate that the parameter is a primitive.

	m = cls.getMethod("setVisible", new Class[]{Boolean.TYPE});
  or
	m = cls.getMethod("setVisible", Boolean.TYPE);

  and we can call it:
	`m.invoke(obj, new Object[]{new Boolean(true)});`
  or
	`m.invoke(obj, new Boolean(true));`
  or
	`m.invoke(obj, true);`
  thanks to the automatic wrapping and unwrapping of primitives.

  Note that  cls.getMethod("setVisible", new Boolean(false).getClass())  would not return a method because there is no setVisible method that takes Boolean as input.

Similarly we can access the fields of the class:
	`cls.getFields()`  - returns an array containing all public fields info
	`cls.getDeclaredFields() `- returns an array containing info about all fields declared in this class, public or private


  	Field[] fields = cls.getDeclaredFields();

  Now, given a field, we can access it:
	`fields[0].get(obj)`   -> returns the value stored in obj's field
	`fields[0].set(obj, value)`   -> changes the value of obj's field to value


Accessing private fields and methods
  We can change the accessibility of any field or method in the class using the setAccessible() method.
  This is really useful for JUnit testing private methods.


As one student noted, reflection can let you access methods of anonymous classes.
   Normally, we we create a method in an anonymous class, it is only to override an existing method.
   There is no point in creating a new method in an anonymous class because you can't access it from outside the anonymous class.
   Why?  Anytime you call a method on an object, the compiler uses the "current type" to determine if the method call is valid, and
      then Java runs the true type version.
   You can't typecast a value of an anonymous class to its true type because the true type of an anonymous class has no name!
But with relection, we can get the true type of the anonymous class, and then get the methods available to the true type.



Below is the transcript from the in-person lecture.
Most of this is manipulating methods and fields of JFrame, but at the end, we create an anonymous class and show how to access a method of the class - which is impossible with "normal" Java.

```ad-abstract

> Welcome to DrJava.  Working directory is /home/hsc/courses/132
> import javax.swing.JFrame
> JFrame j = new JFrame()
> Class cls = j.getClass()
> cls
class javax.swing.JFrame
> cls.getMethods()
{ public javax.accessibility.AccessibleContext javax.swing.JFrame.getAccessibleContext(), public java.awt.Container javax.swing.JFrame.getContentPane(), public int javax.swing.JFrame.getDefaultCloseOperation(), public java.awt.Component javax.swing.JFrame.getGlassPane(), public java.awt.Graphics javax.swing.JFrame.getGraphics(), public javax.swing.JMenuBar javax.swing.JFrame.getJMenuBar(), public javax.swing.JLayeredPane javax.swing.JFrame.getLayeredPane(), public javax.swing.JRootPane javax.swing.JFrame.getRootPane(), public javax.swing.TransferHandler javax.swing.JFrame.getTransferHandler(), public static boolean javax.swing.JFrame.isDefaultLookAndFeelDecorated(), public void javax.swing.JFrame.repaint(long,int,int,int,int), public void javax.swing.JFrame.setContentPane(java.awt.Container), public void javax.swing.JFrame.setDefaultCloseOperation(int), public static void javax.swing.JFrame.setDefaultLookAndFeelDecorated(boolean), public void javax.swing.JFrame.setGlassPane(java.awt.Component), public void javax.swing.JFrame.setIconImage(java.awt.Image), public void javax.swing.JFrame.setJMenuBar(javax.swing.JMenuBar), public void javax.swing.JFrame.setLayeredPane(javax.swing.JLayeredPane), public void javax.swing.JFrame.setLayout(java.awt.LayoutManager), public void javax.swing.JFrame.setTransferHandler(javax.swing.TransferHandler), public void javax.swing.JFrame.remove(java.awt.Component), public void javax.swing.JFrame.update(java.awt.Graphics), public java.awt.MenuBar java.awt.Frame.getMenuBar(), public void java.awt.Frame.setBackground(java.awt.Color), public void java.awt.Frame.setMenuBar(java.awt.MenuBar), public void java.awt.Frame.setUndecorated(boolean), public void java.awt.Frame.addNotify(), public int java.awt.Frame.getCursorType(), public int java.awt.Frame.getExtendedState(), public static java.awt.Frame[] java.awt.Frame.getFrames(), public java.awt.Image java.awt.Frame.getIconImage(), public java.awt.Rectangle java.awt.Frame.getMaximizedBounds(), public java.lang.String java.awt.Frame.getTitle(), public boolean java.awt.Frame.isResizable(), public boolean java.awt.Frame.isUndecorated(), public void java.awt.Frame.removeNotify(), public void java.awt.Frame.setCursor(int), public void java.awt.Frame.setExtendedState(int), public void java.awt.Frame.setMaximizedBounds(java.awt.Rectangle), public void java.awt.Frame.setOpacity(float), public void java.awt.Frame.setResizable(boolean), public void java.awt.Frame.setShape(java.awt.Shape), public void java.awt.Frame.setTitle(java.lang.String), public synchronized void java.awt.Frame.setState(int), public void java.awt.Frame.remove(java.awt.MenuComponent), public synchronized int java.awt.Frame.getState(), public java.util.Locale java.awt.Window.getLocale(), public void java.awt.Window.paint(java.awt.Graphics), public java.awt.Color java.awt.Window.getBackground(), public float java.awt.Window.getOpacity(), public java.awt.Shape java.awt.Window.getShape(), public java.awt.Toolkit java.awt.Window.getToolkit(), public static java.awt.Window[] java.awt.Window.getWindows(), public void java.awt.Window.setCursor(java.awt.Cursor), public boolean java.awt.Window.postEvent(java.awt.Event), public synchronized void java.awt.Window.addWindowFocusListener(java.awt.event.WindowFocusListener), public synchronized void java.awt.Window.addWindowListener(java.awt.event.WindowListener), public synchronized void java.awt.Window.addWindowStateListener(java.awt.event.WindowStateListener), public void java.awt.Window.applyResourceBundle(java.lang.String), public void java.awt.Window.applyResourceBundle(java.util.ResourceBundle), public void java.awt.Window.createBufferStrategy(int), public void java.awt.Window.createBufferStrategy(int,java.awt.BufferCapabilities) throws java.awt.AWTException, public java.awt.image.BufferStrategy java.awt.Window.getBufferStrategy(), public final java.awt.Container java.awt.Window.getFocusCycleRootAncestor(), public java.awt.Component java.awt.Window.getFocusOwner(), public java.util.Set java.awt.Window.getFocusTraversalKeys(int), public boolean java.awt.Window.getFocusableWindowState(), public java.util.List java.awt.Window.getIconImages(), public java.awt.im.InputContext java.awt.Window.getInputContext(), public java.util.EventListener[] java.awt.Window.getListeners(java.lang.Class), public java.awt.Dialog\$ModalExclusionType java.awt.Window.getModalExclusionType(), public java.awt.Component java.awt.Window.getMostRecentFocusOwner(), public java.awt.Window[] java.awt.Window.getOwnedWindows(), public static java.awt.Window[] java.awt.Window.getOwnerlessWindows(), public final java.lang.String java.awt.Window.getWarningString(), public synchronized java.awt.event.WindowFocusListener[] java.awt.Window.getWindowFocusListeners(), public synchronized java.awt.event.WindowListener[] java.awt.Window.getWindowListeners(), public synchronized java.awt.event.WindowStateListener[] java.awt.Window.getWindowStateListeners(), public void java.awt.Window.hide(), public boolean java.awt.Window.isActive(), public final boolean java.awt.Window.isAlwaysOnTop(), public boolean java.awt.Window.isAlwaysOnTopSupported(), public boolean java.awt.Window.isAutoRequestFocus(), public final boolean java.awt.Window.isFocusCycleRoot(), public final boolean java.awt.Window.isFocusableWindow(), public boolean java.awt.Window.isFocused(), public boolean java.awt.Window.isLocationByPlatform(), public boolean java.awt.Window.isShowing(), public boolean java.awt.Window.isValidateRoot(), public synchronized void java.awt.Window.removeWindowFocusListener(java.awt.event.WindowFocusListener), public synchronized void java.awt.Window.removeWindowListener(java.awt.event.WindowListener), public synchronized void java.awt.Window.removeWindowStateListener(java.awt.event.WindowStateListener), public void java.awt.Window.reshape(int,int,int,int), public final void java.awt.Window.setAlwaysOnTop(boolean) throws java.lang.SecurityException, public void java.awt.Window.setAutoRequestFocus(boolean), public final void java.awt.Window.setFocusCycleRoot(boolean), public void java.awt.Window.setFocusableWindowState(boolean), public synchronized void java.awt.Window.setIconImages(java.util.List), public void java.awt.Window.setLocation(java.awt.Point), public void java.awt.Window.setLocation(int,int), public void java.awt.Window.setLocationByPlatform(boolean), public void java.awt.Window.setLocationRelativeTo(java.awt.Component), public void java.awt.Window.setMinimumSize(java.awt.Dimension), public void java.awt.Window.setModalExclusionType(java.awt.Dialog\$ModalExclusionType), public void java.awt.Window.show(), public void java.awt.Window.toBack(), public void java.awt.Window.toFront(), public void java.awt.Window.setVisible(boolean), public void java.awt.Window.setBounds(java.awt.Rectangle), public void java.awt.Window.setBounds(int,int,int,int), public void java.awt.Window.setType(java.awt.Window\$Type), public void java.awt.Window.addPropertyChangeListener(java.beans.PropertyChangeListener), public void java.awt.Window.addPropertyChangeListener(java.lang.String,java.beans.PropertyChangeListener), public void java.awt.Window.dispose(), public java.awt.Window\$Type java.awt.Window.getType(), public void java.awt.Window.setSize(java.awt.Dimension), public void java.awt.Window.setSize(int,int), public boolean java.awt.Window.isOpaque(), public java.awt.Window java.awt.Window.getOwner(), public void java.awt.Window.pack(), public synchronized void java.awt.Container.addContainerListener(java.awt.event.ContainerListener), public boolean java.awt.Container.areFocusTraversalKeysSet(int), public int java.awt.Container.countComponents(), public void java.awt.Container.deliverEvent(java.awt.Event), public void java.awt.Container.doLayout(), public java.awt.Component java.awt.Container.findComponentAt(int,int), public java.awt.Component java.awt.Container.findComponentAt(java.awt.Point), public float java.awt.Container.getAlignmentX(), public float java.awt.Container.getAlignmentY(), public java.awt.Component java.awt.Container.getComponentAt(int,int), public java.awt.Component java.awt.Container.getComponentAt(java.awt.Point), public int java.awt.Container.getComponentZOrder(java.awt.Component), public java.awt.Component[] java.awt.Container.getComponents(), public synchronized java.awt.event.ContainerListener[] java.awt.Container.getContainerListeners(), public java.awt.Insets java.awt.Container.getInsets(), public java.awt.LayoutManager java.awt.Container.getLayout(), public java.awt.Dimension java.awt.Container.getMaximumSize(), public java.awt.Point java.awt.Container.getMousePosition(boolean) throws java.awt.HeadlessException, public java.awt.Insets java.awt.Container.insets(), public boolean java.awt.Container.isAncestorOf(java.awt.Component), public final boolean java.awt.Container.isFocusTraversalPolicyProvider(), public boolean java.awt.Container.isFocusTraversalPolicySet(), public void java.awt.Container.layout(), public java.awt.Component java.awt.Container.locate(int,int), public java.awt.Dimension java.awt.Container.minimumSize(), public void java.awt.Container.paintComponents(java.awt.Graphics), public java.awt.Dimension java.awt.Container.preferredSize(), public void java.awt.Container.printComponents(java.awt.Graphics), public synchronized void java.awt.Container.removeContainerListener(java.awt.event.ContainerListener), public void java.awt.Container.setComponentZOrder(java.awt.Component,int), public void java.awt.Container.setFocusTraversalKeys(int,java.util.Set), public void java.awt.Container.setFocusTraversalPolicy(java.awt.FocusTraversalPolicy), public final void java.awt.Container.setFocusTraversalPolicyProvider(boolean), public void java.awt.Container.setFont(java.awt.Font), public void java.awt.Container.transferFocusDownCycle(), public void java.awt.Container.applyComponentOrientation(java.awt.ComponentOrientation), public java.awt.Component java.awt.Container.getComponent(int), public int java.awt.Container.getComponentCount(), public java.awt.FocusTraversalPolicy java.awt.Container.getFocusTraversalPolicy(), public java.awt.Dimension java.awt.Container.getMinimumSize(), public java.awt.Dimension java.awt.Container.getPreferredSize(), public void java.awt.Container.invalidate(), public boolean java.awt.Container.isFocusCycleRoot(java.awt.Container), public void java.awt.Container.add(java.awt.Component,java.lang.Object), public java.awt.Component java.awt.Container.add(java.awt.Component,int), public java.awt.Component java.awt.Container.add(java.lang.String,java.awt.Component), public void java.awt.Container.add(java.awt.Component,java.lang.Object,int), public java.awt.Component java.awt.Container.add(java.awt.Component), public void java.awt.Container.remove(int), public void java.awt.Container.list(java.io.PrintStream,int), public void java.awt.Container.list(java.io.PrintWriter,int), public void java.awt.Container.print(java.awt.Graphics), public void java.awt.Container.removeAll(), public void java.awt.Container.validate(), public final void java.awt.Component.dispatchEvent(java.awt.AWTEvent), public java.awt.Point java.awt.Component.getMousePosition() throws java.awt.HeadlessException, public boolean java.awt.Component.isFocusOwner(), public boolean java.awt.Component.isFocusable(), public boolean java.awt.Component.isLightweight(), public boolean java.awt.Component.isMaximumSizeSet(), public boolean java.awt.Component.isPreferredSizeSet(), public void java.awt.Component.transferFocus(), public void java.awt.Component.transferFocusBackward(), public boolean java.awt.Component.action(java.awt.Event,java.lang.Object), public synchronized void java.awt.Component.addComponentListener(java.awt.event.ComponentListener), public synchronized void java.awt.Component.addFocusListener(java.awt.event.FocusListener), public void java.awt.Component.addHierarchyBoundsListener(java.awt.event.HierarchyBoundsListener), public void java.awt.Component.addHierarchyListener(java.awt.event.HierarchyListener), public synchronized void java.awt.Component.addInputMethodListener(java.awt.event.InputMethodListener), public synchronized void java.awt.Component.addKeyListener(java.awt.event.KeyListener), public synchronized void java.awt.Component.addMouseListener(java.awt.event.MouseListener), public synchronized void java.awt.Component.addMouseMotionListener(java.awt.event.MouseMotionListener), public synchronized void java.awt.Component.addMouseWheelListener(java.awt.event.MouseWheelListener), public int java.awt.Component.checkImage(java.awt.Image,int,int,java.awt.image.ImageObserver), public int java.awt.Component.checkImage(java.awt.Image,java.awt.image.ImageObserver), public java.awt.Image java.awt.Component.createImage(java.awt.image.ImageProducer), public java.awt.Image java.awt.Component.createImage(int,int), public java.awt.image.VolatileImage java.awt.Component.createVolatileImage(int,int), public java.awt.image.VolatileImage java.awt.Component.createVolatileImage(int,int,java.awt.ImageCapabilities) throws java.awt.AWTException, public void java.awt.Component.enableInputMethods(boolean), public int java.awt.Component.getBaseline(int,int), public java.awt.Component$BaselineResizeBehavior java.awt.Component.getBaselineResizeBehavior(), public java.awt.image.ColorModel java.awt.Component.getColorModel(), public synchronized java.awt.event.ComponentListener[] java.awt.Component.getComponentListeners(), public java.awt.ComponentOrientation java.awt.Component.getComponentOrientation(), public synchronized java.awt.dnd.DropTarget java.awt.Component.getDropTarget(), public synchronized java.awt.event.FocusListener[] java.awt.Component.getFocusListeners(), public boolean java.awt.Component.getFocusTraversalKeysEnabled(), public java.awt.FontMetrics java.awt.Component.getFontMetrics(java.awt.Font), public java.awt.Color java.awt.Component.getForeground(), public synchronized java.awt.event.HierarchyBoundsListener[] java.awt.Component.getHierarchyBoundsListeners(), public synchronized java.awt.event.HierarchyListener[] java.awt.Component.getHierarchyListeners(), public boolean java.awt.Component.getIgnoreRepaint(), public synchronized java.awt.event.InputMethodListener[] java.awt.Component.getInputMethodListeners(), public java.awt.im.InputMethodRequests java.awt.Component.getInputMethodRequests(), public synchronized java.awt.event.KeyListener[] java.awt.Component.getKeyListeners(), public synchronized java.awt.event.MouseListener[] java.awt.Component.getMouseListeners(), public synchronized java.awt.event.MouseMotionListener[] java.awt.Component.getMouseMotionListeners(), public synchronized java.awt.event.MouseWheelListener[] java.awt.Component.getMouseWheelListeners(), public java.beans.PropertyChangeListener[] java.awt.Component.getPropertyChangeListeners(java.lang.String), public java.beans.PropertyChangeListener[] java.awt.Component.getPropertyChangeListeners(), public boolean java.awt.Component.gotFocus(java.awt.Event,java.lang.Object), public boolean java.awt.Component.hasFocus(), public boolean java.awt.Component.imageUpdate(java.awt.Image,int,int,int,int,int), public boolean java.awt.Component.inside(int,int), public boolean java.awt.Component.isBackgroundSet(), public boolean java.awt.Component.isCursorSet(), public boolean java.awt.Component.isDoubleBuffered(), public boolean java.awt.Component.isFocusTraversable(), public boolean java.awt.Component.isFontSet(), public boolean java.awt.Component.isForegroundSet(), public boolean java.awt.Component.keyDown(java.awt.Event,int), public boolean java.awt.Component.keyUp(java.awt.Event,int), public boolean java.awt.Component.lostFocus(java.awt.Event,java.lang.Object), public boolean java.awt.Component.mouseDown(java.awt.Event,int,int), public boolean java.awt.Component.mouseDrag(java.awt.Event,int,int), public boolean java.awt.Component.mouseEnter(java.awt.Event,int,int), public boolean java.awt.Component.mouseExit(java.awt.Event,int,int), public boolean java.awt.Component.mouseMove(java.awt.Event,int,int), public boolean java.awt.Component.mouseUp(java.awt.Event,int,int), public void java.awt.Component.move(int,int), public void java.awt.Component.nextFocus(), public void java.awt.Component.paintAll(java.awt.Graphics), public boolean java.awt.Component.prepareImage(java.awt.Image,int,int,java.awt.image.ImageObserver), public boolean java.awt.Component.prepareImage(java.awt.Image,java.awt.image.ImageObserver), public void java.awt.Component.printAll(java.awt.Graphics), public synchronized void java.awt.Component.removeComponentListener(java.awt.event.ComponentListener), public synchronized void java.awt.Component.removeFocusListener(java.awt.event.FocusListener), public void java.awt.Component.removeHierarchyBoundsListener(java.awt.event.HierarchyBoundsListener), public void java.awt.Component.removeHierarchyListener(java.awt.event.HierarchyListener), public synchronized void java.awt.Component.removeInputMethodListener(java.awt.event.InputMethodListener), public synchronized void java.awt.Component.removeKeyListener(java.awt.event.KeyListener), public synchronized void java.awt.Component.removeMouseListener(java.awt.event.MouseListener), public synchronized void java.awt.Component.removeMouseMotionListener(java.awt.event.MouseMotionListener), public synchronized void java.awt.Component.removeMouseWheelListener(java.awt.event.MouseWheelListener), public boolean java.awt.Component.requestFocusInWindow(), public void java.awt.Component.revalidate(), public void java.awt.Component.setComponentOrientation(java.awt.ComponentOrientation), public synchronized void java.awt.Component.setDropTarget(java.awt.dnd.DropTarget), public void java.awt.Component.setFocusTraversalKeysEnabled(boolean), public void java.awt.Component.setFocusable(boolean), public void java.awt.Component.setForeground(java.awt.Color), public void java.awt.Component.setIgnoreRepaint(boolean), public void java.awt.Component.setMaximumSize(java.awt.Dimension), public void java.awt.Component.setPreferredSize(java.awt.Dimension), public void java.awt.Component.transferFocusUpCycle(), public java.awt.Rectangle java.awt.Component.getBounds(java.awt.Rectangle), public java.awt.Rectangle java.awt.Component.getBounds(), public void java.awt.Component.firePropertyChange(java.lang.String,long,long), public void java.awt.Component.firePropertyChange(java.lang.String,float,float), public void java.awt.Component.firePropertyChange(java.lang.String,double,double), public void java.awt.Component.firePropertyChange(java.lang.String,byte,byte), public void java.awt.Component.firePropertyChange(java.lang.String,char,char), public void java.awt.Component.firePropertyChange(java.lang.String,short,short), public void java.awt.Component.repaint(long), public void java.awt.Component.repaint(), public void java.awt.Component.repaint(int,int,int,int), public java.awt.Cursor java.awt.Component.getCursor(), public final java.lang.Object java.awt.Component.getTreeLock(), public boolean java.awt.Component.isDisplayable(), public java.awt.Font java.awt.Component.getFont(), public java.awt.GraphicsConfiguration java.awt.Component.getGraphicsConfiguration(), public int java.awt.Component.getHeight(), public java.awt.Point java.awt.Component.getLocationOnScreen(), public java.awt.peer.ComponentPeer java.awt.Component.getPeer(), public int java.awt.Component.getWidth(), public int java.awt.Component.getX(), public int java.awt.Component.getY(), public boolean java.awt.Component.handleEvent(java.awt.Event), public boolean java.awt.Component.isMinimumSizeSet(), public boolean java.awt.Component.isVisible(), public void java.awt.Component.requestFocus(), public void java.awt.Component.show(boolean), public boolean java.awt.Component.isEnabled(), public void java.awt.Component.setEnabled(boolean), public java.awt.Rectangle java.awt.Component.bounds(), public void java.awt.Component.removePropertyChangeListener(java.beans.PropertyChangeListener), public void java.awt.Component.removePropertyChangeListener(java.lang.String,java.beans.PropertyChangeListener), public void java.awt.Component.add(java.awt.PopupMenu), public java.lang.String java.awt.Component.toString(), public java.lang.String java.awt.Component.getName(), public boolean java.awt.Component.contains(java.awt.Point), public boolean java.awt.Component.contains(int,int), public java.awt.Dimension java.awt.Component.size(), public java.awt.Point java.awt.Component.getLocation(), public java.awt.Point java.awt.Component.getLocation(java.awt.Point), public java.awt.Container java.awt.Component.getParent(), public void java.awt.Component.setName(java.lang.String), public void java.awt.Component.list(), public void java.awt.Component.list(java.io.PrintWriter), public void java.awt.Component.list(java.io.PrintStream), public java.awt.Dimension java.awt.Component.getSize(java.awt.Dimension), public java.awt.Dimension java.awt.Component.getSize(), public void java.awt.Component.resize(int,int), public void java.awt.Component.resize(java.awt.Dimension), public java.awt.Point java.awt.Component.location(), public void java.awt.Component.disable(), public void java.awt.Component.enable(boolean), public void java.awt.Component.enable(), public void java.awt.Component.setLocale(java.util.Locale), public boolean java.awt.Component.isValid(), public final void java.lang.Object.wait() throws java.lang.InterruptedException, public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll() }
> cls.getMethods().length
329
> import java.lang.reflect.Method
> Method m = cls.getMethod("setTitle", String)
Static Error: Undefined name 'String'
> Method m = cls.getMethod("setTitle", "".getClass())
> m
public void java.awt.Frame.setTitle(java.lang.String)
> m = cls.getMethod("setTitle", new Class[]{"".getClass()})
public void java.awt.Frame.setTitle(java.lang.String)
> m
public void java.awt.Frame.setTitle(java.lang.String)
> m.invoke(j, "This is Cool")
null
> m = cls.getMethod("setVisible", true.getClass())
Static Error: No method in boolean has name 'getClass'
> m = cls.getMethod("setVisible", new Boolean(true).getClass())
java.lang.NoSuchMethodException: javax.swing.JFrame.setVisible(java.lang.Boolean)
	at java.lang.Class.getMethod(Class.java:1773)
> m = cls.getMethod("setVisible", boolean)
Incomplete expression
> m = cls.getMethod("setVisible", Boolean.TYPE)
public void java.awt.Window.setVisible(boolean)
> m
public void java.awt.Window.setVisible(boolean)
> m.invoke(j, true)
null
> m = cls.getMethod("setSize", Integer.TYPE)
java.lang.NoSuchMethodException: javax.swing.JFrame.setSize(int)
	at java.lang.Class.getMethod(Class.java:1773)
> m = cls.getMethod("setSize", Integer.TYPE, Integer.TYPE)
public void java.awt.Window.setSize(int,int)
> m = cls.getMethod("setSize", new Class[]{Integer.TYPE, Integer.TYPE})
public void java.awt.Window.setSize(int,int)
> m.invoke(j, 500, 300)
null
> cls.getDeclaredFields()
{ public static final int javax.swing.JFrame.EXIT_ON_CLOSE, private static final java.lang.Object javax.swing.JFrame.defaultLookAndFeelDecoratedKey, private int javax.swing.JFrame.defaultCloseOperation, private javax.swing.TransferHandler javax.swing.JFrame.transferHandler, protected javax.swing.JRootPane javax.swing.JFrame.rootPane, protected boolean javax.swing.JFrame.rootPaneCheckingEnabled, protected javax.accessibility.AccessibleContext javax.swing.JFrame.accessibleContext }
> cls.getDeclaredFields().length
7
> cls.getFields()
{ public static final int javax.swing.JFrame.EXIT_ON_CLOSE, public static final int javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE, public static final int javax.swing.WindowConstants.HIDE_ON_CLOSE, public static final int javax.swing.WindowConstants.DISPOSE_ON_CLOSE, public static final int javax.swing.WindowConstants.EXIT_ON_CLOSE, public static final int java.awt.Frame.DEFAULT_CURSOR, public static final int java.awt.Frame.CROSSHAIR_CURSOR, public static final int java.awt.Frame.TEXT_CURSOR, public static final int java.awt.Frame.WAIT_CURSOR, public static final int java.awt.Frame.SW_RESIZE_CURSOR, public static final int java.awt.Frame.SE_RESIZE_CURSOR, public static final int java.awt.Frame.NW_RESIZE_CURSOR, public static final int java.awt.Frame.NE_RESIZE_CURSOR, public static final int java.awt.Frame.N_RESIZE_CURSOR, public static final int java.awt.Frame.S_RESIZE_CURSOR, public static final int java.awt.Frame.W_RESIZE_CURSOR, public static final int java.awt.Frame.E_RESIZE_CURSOR, public static final int java.awt.Frame.HAND_CURSOR, public static final int java.awt.Frame.MOVE_CURSOR, public static final int java.awt.Frame.NORMAL, public static final int java.awt.Frame.ICONIFIED, public static final int java.awt.Frame.MAXIMIZED_HORIZ, public static final int java.awt.Frame.MAXIMIZED_VERT, public static final int java.awt.Frame.MAXIMIZED_BOTH, public static final float java.awt.Component.TOP_ALIGNMENT, public static final float java.awt.Component.CENTER_ALIGNMENT, public static final float java.awt.Component.BOTTOM_ALIGNMENT, public static final float java.awt.Component.LEFT_ALIGNMENT, public static final float java.awt.Component.RIGHT_ALIGNMENT, public static final int java.awt.image.ImageObserver.WIDTH, public static final int java.awt.image.ImageObserver.HEIGHT, public static final int java.awt.image.ImageObserver.PROPERTIES, public static final int java.awt.image.ImageObserver.SOMEBITS, public static final int java.awt.image.ImageObserver.FRAMEBITS, public static final int java.awt.image.ImageObserver.ALLBITS, public static final int java.awt.image.ImageObserver.ERROR, public static final int java.awt.image.ImageObserver.ABORT }
> 
> 
> import java.lang.reflect.Field
> Field[] fields = cls.getDeclaredFields()
> fields
{ public static final int javax.swing.JFrame.EXIT_ON_CLOSE, private static final java.lang.Object javax.swing.JFrame.defaultLookAndFeelDecoratedKey, private int javax.swing.JFrame.defaultCloseOperation, private javax.swing.TransferHandler javax.swing.JFrame.transferHandler, protected javax.swing.JRootPane javax.swing.JFrame.rootPane, protected boolean javax.swing.JFrame.rootPaneCheckingEnabled, protected javax.accessibility.AccessibleContext javax.swing.JFrame.accessibleContext }
> fields[0]
public static final int javax.swing.JFrame.EXIT_ON_CLOSE
> fields[1]
private static final java.lang.Object javax.swing.JFrame.defaultLookAndFeelDecoratedKey
> fields[2]
private int javax.swing.JFrame.defaultCloseOperation
> 
> 
> fields[0]
public static final int javax.swing.JFrame.EXIT_ON_CLOSE
> fields[0].get(null)
3
> fields[0].get(j)
3
> fields[1]
private static final java.lang.Object javax.swing.JFrame.defaultLookAndFeelDecoratedKey
> fields[1].get(null)
java.lang.IllegalAccessException: Class edu.rice.cs.dynamicjava.symbol.JavaClass$JavaMethod can not access a member of class javax.swing.JFrame with modifiers "private static final"
	at sun.reflect.Reflection.ensureMemberAccess(Reflection.java:101)
	at java.lang.reflect.AccessibleObject.slowCheckMemberAccess(AccessibleObject.java:295)
	at java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:287)
	at java.lang.reflect.Field.get(Field.java:384)
> fields[2]
private int javax.swing.JFrame.defaultCloseOperation
> fields[2].get(j)
java.lang.IllegalAccessException: Class edu.rice.cs.dynamicjava.symbol.JavaClass$JavaMethod can not access a member of class javax.swing.JFrame with modifiers "private"
	at sun.reflect.Reflection.ensureMemberAccess(Reflection.java:101)
	at java.lang.reflect.AccessibleObject.slowCheckMemberAccess(AccessibleObject.java:295)
	at java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:287)
	at java.lang.reflect.Field.get(Field.java:384)
> fields[2].setAccessible(true)
> fields[2].get(j)
1
> fields[2].set(j, 100)
> fields[2].get(j)
100
> fields[2]
private int javax.swing.JFrame.defaultCloseOperation
> import java.util.Comparator
> Comparator<Integer> c = new Comparator<Integer>() {
    public int compare(int x, int y) {
      return test(x) - test(y);
    }

    public int test(int x) {
      return x % 100;
    }
  }
> c
$1@c9d253
> c.test(3)
Static Error: No method in Comparator<Integer> has name 'test'
> cls = c.getClass()
class $1
> c
$1@c9d253
> cls.getMethod("test", Integer.TYPE)
public int $1.test(int)
> 
```
