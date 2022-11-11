package com.github.xpenatan.imgui.core.generate;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.core.codeparser.IDLDefaultCodeParser;
import com.github.xpenatan.jparser.core.idl.IDLFile;

public class ImGuiCppParser extends IDLDefaultCodeParser {
    public ImGuiCppParser(IDLFile idlFile) {
        super("cpp", idlFile);
    }

    @Override
    protected void onIDLMethodGenerated(JParser jParser, CompilationUnit compilationUnit, ClassOrInterfaceDeclaration classOrInterfaceDeclaration, MethodDeclaration methodDeclaration, boolean b) {

    }
}
