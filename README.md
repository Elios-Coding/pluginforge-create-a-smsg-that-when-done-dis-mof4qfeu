# SimpleMessagePlugin

A simple Minecraft plugin for Paper servers (1.21.x).

## Features

*   **`/smsg` Command**: Broadcasts a predefined message in chat.
*   **Player Join Event**: Sends a welcome message to players when they join.
*   **Configurable**: Customize the message and sender name via `config.yml`.

## Building the Plugin

This project uses Maven for dependency management and building.

### Prerequisites

*   Java Development Kit (JDK) 21
*   Apache Maven

### Steps

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/SimpleMessagePlugin.git
    cd SimpleMessagePlugin
    ```

2.  **Build the plugin:**
    ```bash
    mvn clean package
    ```

    This will generate a JAR file in the `target/` directory.

## Installation

1.  Place the generated JAR file into the `plugins/` folder of your Paper Minecraft server.
2.  Start or restart your server.
3.  A `config.yml` file will be generated in the `plugins/SimpleMessagePlugin/` folder, which you can edit to customize the message and sender name.

## Usage

*   **`/smsg`**: Sends the configured message to all players in the chat.
    *   Permission: `simplemessageplugin.smsg` (default for OPs)

## Configuration

The `config.yml` file (located in `plugins/SimpleMessagePlugin/`) allows you to customize the plugin's behavior:

```yaml
simple-message: "Confirmed"
sender-name: "Test"
```

*   `simple-message`: The message that will be broadcasted by the `/smsg` command. Color codes with `&` are supported.
*   `sender-name`: The name that will appear as the sender of the message. Color codes with `&` are supported, but will be stripped for the actual sender name display.