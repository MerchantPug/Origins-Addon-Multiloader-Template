# Origins Addon MultiLoader Template

This project provides a Gradle project template that can compile Origins addons for both Forge and Fabric using a common sourceset. This project does not require any third party libraries or dependencies.

## Getting Started

## IntelliJ IDEA
This guide will show how to import the MultiLoader Template into IntelliJ IDEA. The setup process is roughly equivalent to setting up Forge and Fabric independently and should be very familiar to anyone who has worked with their MDKs.

1. Clone or download this repository to your computer.
2. Configure the project by editing the `group`, `mod_name`, `mod_author`, and `mod_id` properties in the `gradle.properties` file. You will also need to change the `rootProject.name`  property in `settings.gradle`.
3. Open the template's root folder as a new project in IDEA. This is the folder that contains this README file and the gradlew executable.
4. If your default JVM/JDK is not Java 17 you will encounter an error when opening the project. This error is fixed by going to `File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JVM`and changing the value to a valid Java 17 JVM. You will also need to set the Project SDK to Java 17. This can be done by going to `File > Project Structure > Project SDK`. Once both have been set open the Gradle tab in IDEA and click the refresh button to reload the project.
5. Open the Gradle tab in IDEA if it has not already been opened. Navigate to `Your Project > Common > Tasks > vanilla gradle > decompile`. Run this task to decompile Minecraft.
6. Open the Gradle tab in IDEA if it has not already been opened. Navigate to `Your Project > Forge > Tasks > forgegradle runs > genIntellijRuns`. Run this task to set up run configurations for Forge.
7. Open your Run/Debug Configurations. Under the Application category there should now be options to run Forge and Fabric projects. Select one of the client options and try to run it.
8. Assuming you were able to run the game in step 7 your workspace should now be set up.

### Eclipse
While it is possible to use this template in Eclipse it is not recommended. During the development of this template multiple critical bugs and quirks related to Eclipse were found at nearly every level of the required build tools. While we continue to work with these tools to report and resolve issues support for projects like these are not there yet. For now Eclipse is considered unsupported by this project. The development cycle for build tools is notoriously slow so there are no ETAs available.

## Origins Specifics

### General
- Origins Addon Multiloader Template uses Origins Fabric's systems as Origins Forge has a compatibility layer for Origins Fabric's Power Factories. This means you'll be using Calio Fabric's SerializableDataType system as opposed to Codecs.

### Setup
- Replace the mentions of `yourmodid`, `examplemod` and any other named classes with your own modid, this is so you don't have mixin conflicts between you and anybody else who is using this template.

### Differences to Origins Fabric's Systems
- Item Actions use `Mutable<ItemStack>` as opposed to an `ItemStack`. `Mutable<ItemStack>`s are used as it's used by Apoli Forge to change an ItemStack's item instead of mixins like in Origins Fabric.
- Item Conditions additionally take in a `Level` parameter or are a `Predicate<Pair<Level, ItemStack>` due to Origins Forge requiring it, this extra parameter isn't used by Origins Fabric item conditions. 

## Development Guide
When using this template the majority of your mod is developed in the Common project. The Common project is compiled against the vanilla game and is used to hold code that is shared between the different loader-specific versions of your mod. The Common project has no knowledge or access to ModLoader specific code, apis, or concepts. Code that requires something from a specific loader must be done through the project that is specific to that loader, such as the Forge or Fabric project.

Loader specific projects such as the Forge and Fabric project are used to load the Common project into the game. These projects also define code that is specific to that loader. Loader specific projects can access all of the code in the Common project. It is important to remember that the Common project can not access code from loader specific projects.

Origins Multiloader's Common module references Origins Forge, this is because it has a compatibility layer for Origins Fabric's code.

## Special Thanks
- Darkhax and Jared - The developers of the MultiLoader Template that this is based on.
- Apace100 - The developer of Origins Fabric. 😎
- EdwinMindcraft - The developer of Origins Forge especially for maintaining a compatibility layer with Origins Fabric making this whole project possible.
- LimonBlaze - Basically rewriting the entire project from what it originally was. If there's anybody to thank, it's you.