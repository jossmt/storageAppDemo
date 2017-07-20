gradle clean war
cd /usr/local/Tomcat/bin
sh shutdown.sh
cp ~/Desktop/storageAppDemo/controller/build/libs/storageAppDemo.war /usr/local/Tomcat/webapps/
cd /usr/local/Tomcat/bin
sh startup.sh
