package jade;

import org.lwjgl.Version;
// For CallBack error
import org.lwjgl.glfw.GLFWErrorCallback;

import org.lwjgl.opengl.GL;
// For glfw Initialization
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class Window {
    private final int width;
    private final int height;
    private final String title;
    private long glfwWindow;
    private static Window window = null;


    private Window() {
        this.width = 1920;
        this.height = 1080;
        this.title = "Mario";
    }

    // Singleton Access instance only
    public static Window get() {
        if (Window.window == null) {
            Window.window = new Window();
        }
        return Window.window;
    }
        // Run
    public void run() {
        System.out.println("Hi This Is My Java Game Engine By ErickDavesTech");
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        init();
        loop();

    }

    public void init (){
        //Setup an Error Callback
        GLFWErrorCallback.createPrint(System.err).set();
        // Initialize GLFW
        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        // Configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);
        // Create Window,
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        // If failed to create the window
        if(glfwWindow ==NULL){
          throw new IllegalStateException("Failed to create the GLFW window");
        };
        // Make the OpenGl context for the current long glfwWindow
        glfwMakeContextCurrent(glfwWindow);
        // Enable V-sync
        glfwSwapInterval(1);
        // Make the Window Visible
        glfwShowWindow(glfwWindow);
        //
        GL.createCapabilities();
    };
    public void loop(){
        while (!glfwWindowShouldClose(glfwWindow)){
            glfwPollEvents();
            glClearColor(1.0f,0.0f,0.0f,1.0f);
            // Clear the Window with the specified color using (GL_COLOR_BUFFER_BIT)
            glClear(GL_COLOR_BUFFER_BIT);

            glfwSwapBuffers(glfwWindow);
        };
    };
}
