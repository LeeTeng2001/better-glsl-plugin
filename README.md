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
- [x] Layout qualifier usage validation
- [x] Common live templates like for, new file etc
- [x] Check redefined variable in the same scope
- [x] Swap expensive operation to less expesive one like getText -> textMatches
- [ ] Test code example from Glsl manual
- [ ] Better auto complete, smart function name, variable name filter

## Feature that's good to have but not in top priority
- Add stub for performance and std library (optimise performance)
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

## Plugin description

<!-- Plugin description -->

Who is the target audience for this plugin? Anyone that want to have a smooth, integrated glsl development environment inside their ide. I've tried various shader plugin in VSCode, jetbrain, but all they do is simple syntax highlighting only.

This plugin is still in development, once it's done, it'll bump it version to v1.0.0.

Features 🥰: 
- Code completion for built-in variables, functions, types and more
- Usage reference resolution, scope resolution for variables 
- Syntax highlighter 
- Common error annotator like redefinition of the same variable
- Includes standard library functions & variables
- Formatter to make your code looks good and well indented

Currently, it has some known limitation 🥲:

- Incomplete set of standard library
- No 100% coverage of glsl expression
- No member access validation
- No expression validation
- No function parameter validation
- No auto-completion for member access

Please give it a try and leave me with some feedback, together we can make the graphic community great! For more information and development roadmap about this plugin, please visit the github link below.

<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "better-glsl-jetbrain"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/LeeTeng2001/better-glsl-jetbrain/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Resources I used to build this plugin
- [Simple language](https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html), very brief and shallow
- [Reference provider](https://intellij-support.jetbrains.com/hc/en-us/community/posts/206117609-Problems-to-add-PsiReferenceContributor)
- [Reference navigation for custom language](https://intellij-support.jetbrains.com/hc/en-us/community/posts/206763465-Navigation-from-usage-to-declaration-for-custom-language)
- [Code completion and syntax error recovery](https://intellij-support.jetbrains.com/hc/en-us/community/posts/360000081950-Code-completion-and-syntax-error-recovery), talk about pin, error recovery in grammer kit
- [Performance improvement tips](https://intellij-sdk-docs-cn.github.io/intellij/sdk/docs/reference_guide/performance/performance.html), Very helpful

---
Starting plugin template based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
