@ECHO OFF
SET BINDIR=%~dp0
CD /D "%BINDIR%"
java -Xmx4G -Xms2G -jar craftbukkit.jar
PAUSE