package config;

import org.aeonbits.owner.Config;

/**
 * Property reading module
 */
public interface PropertiesConfiguration extends Config {

    @DefaultValue("local") //browserstack
    String platform();

/*

    export DB_NAME="linguando"
    export DB_USER="linguando"
    export DB_PASSWORD="linguando"
    export TARGET_ENV="staging"
*
* */
    @DefaultValue("253d6281bde6")
    String id();

    @DefaultValue("https://%s.www.sv3.lingoda.org")
    CustomType url(String id);

    @DefaultValue("https://%s.admin.sv3.lingoda.org")
    CustomType adminUrl(String id);

    @DefaultValue("https://%s.teacher.sv3.lingoda.org")
    CustomType teacherUrl(String id);

    @DefaultValue("https://ork.lingoda.org/v1/exec/$%s")
    CustomType execUrl(String id);

    @DefaultValue("staging-v3-db-1a-%s.elb.eu-west-1.amazonaws.com")
    CustomType dbHost(String id);

    @DefaultValue("12345677")
    String password();

    @DefaultValue("/usr/local/lib/node_modules/appium/build/lib/main.js")
    String mainJSpath();

    @DefaultValue("6000")
    int defaultTimeout();

    @DefaultValue("60000")
    int longTimeout();

    @DefaultValue("error")
    String logLevel();
}
