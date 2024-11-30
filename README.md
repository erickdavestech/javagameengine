## Understanding the `init()` and `loop()` Functions

These functions are crucial for setting up and managing the game window using **LWJGL** (Lightweight Java Game Library). 

---

### The `init()` Function

The `init()` function is responsible for initializing GLFW, configuring the window, and setting up the OpenGL context.

#### Code Explanation:

```java
public void init() {
    // Setup an Error Callback
    GLFWErrorCallback.createPrint(System.err).set();

    // Initialize GLFW
    if (!glfwInit()) {
        throw new IllegalStateException("Unable to initialize GLFW");
    }

    // Configure GLFW
    glfwDefaultWindowHints();
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
    glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

    // Create Window
    glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);

    // Check if Window Creation Failed
    if (glfwWindow == NULL) {
        throw new IllegalStateException("Failed to create the GLFW window");
    }

    // Make the OpenGL context current
    glfwMakeContextCurrent(glfwWindow);

    // Enable V-sync
    glfwSwapInterval(1);

    // Make the Window Visible
    glfwShowWindow(glfwWindow);

    // Create OpenGL capabilities
    GL.createCapabilities();
}
