## Understanding the Singleton Pattern

The `Window` class in this game engine follows the **Singleton Design Pattern**, ensuring that only one instance of the `Window` object is created and used throughout the application. This is crucial for game development, as having multiple windows might lead to resource conflicts or unintended behavior.

---

### How the Singleton Pattern Works

The Singleton pattern ensures:
1. **Single Instance**: Only one `Window` object is created during the application's lifecycle.
2. **Global Access**: The instance can be accessed globally without needing to create new objects.

---

### Code Explanation

#### `Window` Class
The `Window` class is responsible for managing the game window. It includes:
1. A **private constructor** to restrict instantiation.
2. A **static method `get()`** to provide access to the single instance of the class.
3. A `run()` method to execute game-specific logic.

Here’s the `Window` class:

```java
package jade;

import org.lwjgl.Version;

public class Window {
    private int width;
    private int height;
    private String title;

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

    public void run() {
        System.out.println("Hi This Is My Java Game Engine By ErickDavesTech");
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
    }
}

import jade.Window;

public class Main {
    public static void main(String[] args) {
        Window window = Window.get(); // Retrieve the singleton instance
        window.run();                 // Run the game engine logic
    }
}

