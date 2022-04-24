package glsl.language.utility;

import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.AdditionalLibraryRootsProvider;
import com.intellij.openapi.roots.SyntheticLibrary;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.PathUtil;
import com.intellij.util.io.URLUtil;
import glsl.language.property.GlslIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

public class GlslStdLibraryProvider extends AdditionalLibraryRootsProvider {
    // Store all library file in this variable
    public static ArrayList<VirtualFile> stdLibFiles = new ArrayList<>();

    @Override
    public @NotNull Collection<SyntheticLibrary> getAdditionalProjectLibraries(@NotNull Project project) {
        var jarPath = PathUtil.getJarPathForClass(GlslStdLibraryProvider.class);
        var folderPath = "std/vulkan";
        VirtualFile dir;

        if (jarPath.endsWith(".jar")) {
            try {
                dir = VfsUtil.findFileByURL(URLUtil.getJarEntryURL(new File(jarPath), folderPath));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            dir = VfsUtil.findFileByIoFile(new File(jarPath + "/" + folderPath), true);

            if (dir == null) {
                var resourceUrl = project.getClass().getClassLoader().getResource(folderPath);
                if (resourceUrl != null) {
                    dir = VfsUtil.findFileByURL(resourceUrl);
                }
            }
        }

        if (dir != null) {
            stdLibFiles.clear();
            for (VirtualFile child : dir.getChildren()) {
                child.putUserData(Key.create("glsl.lib.standard"), true);
                stdLibFiles.add(child);
            }
            var ret = new ArrayList<SyntheticLibrary>();
            ret.add(new GlslStdLibrary(dir));
            return ret;
        }

        return new ArrayList<>();
    }

    // A lot of the code is reference of the lua plugin: https://github.com/Benjamin-Dobell/IntelliJ-Luanalysis/blob/0b53e920af6f1e56a9e39f2ba57a77dde93055f7/src/main/java/com/tang/intellij/lua/project/StdLibraryProvider.kt
    class GlslStdLibrary extends SyntheticLibrary implements ItemPresentation {
        Collection<VirtualFile> roots;

        public GlslStdLibrary(VirtualFile root) {
            roots = new ArrayList<>();
            roots.add(root);
        }

        @Override
        public @NotNull Collection<VirtualFile> getSourceRoots() {
            return roots;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof GlslStdLibrary && ((GlslStdLibrary) o).roots == roots;
        }

        @Override
        public int hashCode() {
            return roots.hashCode();
        }

        @Override
        public @NlsSafe @Nullable String getPresentableText() {
            return "Glsl standard library (placeholder)";
        }

        @Override
        public @NlsSafe @Nullable String getLocationString() {
            return "Glsl standard library for vulkan (placeholder)";
        }

        @Override
        public @Nullable Icon getIcon(boolean unused) {
            return GlslIcons.FILE;
        }
    }
}
