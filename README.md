# better-glsl-jetbrain

![Build](https://github.com/LeeTeng2001/better-glsl-jetbrain/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Roadmap
- [x] Autocomplete function name and variable name
- [x] Member access
- [x] Array support
- [x] Macro, version header
- [x] Built-in function and variables (the essential first)
- [x] Initialise with built-in functions & initializer
- [x] Formatter, auto indentation
- [x] standard library usage styling
- [x] for, while, return expression
- [x] Boolean
- [x] Variable proper scope reference
- [x] Unary, prefix, postfix operation
- [x] Support for vec type, swizzle expression
- [x] Prefix match in auto complete to reduce noise
- [x] Support for matrix type, double array
- [x] Samplers & images & textures keywords
- [ ] Check redefined variable in the same scope
- [ ] Layout qualifier auto complete
- [ ] Add stub for performance and std library
- [ ] Better auto complete, smart function name, variable name filter
- [ ] Test code example from Glsl manual

## Feature that's good to have but not in top priority
- Validate member access like swizzle, array access, valid member name
- Auto complete for member access
- Expression validation (no idea where to start)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [ ] Get familiar with the [template documentation][template].
- [ ] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the Plugin ID in the above README badges.
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This is a plugin that try to give you the native intellij IDE experience for Glsl language, you have the familiar code completion, reference symbol, syntax highlighter, common error annotator, standard library function & variable reference.

This Fancy IntelliJ Platform Plugin is going to be your implementation of the brilliant ideas that you have.

This specific section is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process.

To keep everything working, do not remove `<!-- ... -->` sections. 
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "better-glsl-jetbrain"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/LeeTeng2001/better-glsl-jetbrain/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Resources that help me build this plugin
- [Simple language](https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html), very brief and shallow
- [Reference provider](https://intellij-support.jetbrains.com/hc/en-us/community/posts/206117609-Problems-to-add-PsiReferenceContributor)
- [Reference navigation for custom language](https://intellij-support.jetbrains.com/hc/en-us/community/posts/206763465-Navigation-from-usage-to-declaration-for-custom-language)
- [Code completion and syntax error recovery](https://intellij-support.jetbrains.com/hc/en-us/community/posts/360000081950-Code-completion-and-syntax-error-recovery), talk about pin, error recovery in grammer kit

---
Starting plugin template based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
