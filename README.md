# HITAM CLIENT
### Client untuk bocah hitam!

### A free 1.8.9 mixin-based injection hacked-client for Minecraft using Minecraft Forge based on FDP that based on LiquidBounce.

Discord: Gada Banh ☝️😅

## Issues
Kalo ketemu Issue fix sendiri / ngomong di grup 😅

## License
This project is subject to the [GNU General Public License v3.0](LICENSE). This does only apply for source code located directly in this clean repository. During the development and compilation process, additional source code may be used to which we have obtained no rights. Such code is not covered by the GPL license.

For those who are unfamiliar with the license, here is a summary of its main points. This is by no means legal advise nor legally binding.

You are allowed to
- use
- share
- modify

this project entirely or partially for free and even commercially. However, please consider the following:

- **You must disclose the source code of your modified work and the source code you took from this project. This means you are not allowed to use code from this project (even partially) in a closed-source (or even obfuscated) application.**
- **Your modified application must also be licensed under the GPL** 

Do the above and share your source code with everyone; just like we do.

## Setting up a Workspace
HitamClient uses gradle, so make sure that it is installed properly. Instructions can be found on [Gradle's website](https://gradle.org/install/).
1. Clone the repository using `git clone --recurse-submodules https://github.com/UnlegitMC/FDPClient.git`. 
2. CD into the local repository folder.
3. Depending on which IDE you are using execute either of the following commands:
    - For IntelliJ: `gradlew --debug setupDevWorkspace idea genIntellijRuns build`
    - For Eclipse: `gradlew --debug setupDevWorkspace eclipse build`
4. Open the folder as a Gradle project in your IDE.
5. Select the Forge run configuration.

## Additional libraries
### Mixins
Mixins can be used to modify classes at runtime before they are loaded. FDPClient uses it to inject its code into the Minecraft client. This way, we do not have to ship Mojangs copyrighted code. If you want to learn more about it, check out its [Documentation](https://docs.spongepowered.org/5.1.0/en/plugin/internals/mixins.html).
### Ultralight
Ultralight is a HTML renderer and can be works with LWJGL. If you want to learn more about it, check out its [GitHub repo](https://github.com/labymod/ultralight-java)

## Contributing
We are welcome for your contributing, but you have to follow these rules to make us merge your pull request.

### Language and Code Quality
First of all, your code at least can be build, and make bugs as less as you can!   
And we want to use kotlin features to make coding easier and faster, please use kotlin and make the [Detekt](https://github.com/detekt/detekt) code quality check good and use kotlin features if you can **\***, we never merge shitcode.

#### Kotlin features
Usage of kotlin features and help enhance the code readability    
kotlin feature examples
~~~kotlin
Timer().schedule(2000L) { 
    // your code
}
~~~
not using kotlin feature
~~~kotlin
Timer().schedule(object : TimerTask(){
    override fun run() {
        // your code
    }
},2000L)
~~~

### Skid codes
Awas lu ya banhj skid ini nanti aku aduin ke mamahku lho jahat kamu banhk 😭😭😭😭😭

### Useless features
Useless features means feature only you think its usable ,or feature can be have with config change.  
Like the "TimerSpeed" option to InfiniteAura, this feature can be added with bind Timer to the key with InfiniteAura, or use macro system in FDP Client.
aku sayang liep_
