package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    // items start here
    public static final Prefix PREFIX_ITEM_NAME = new Prefix("-n ");
    public static final Prefix PREFIX_ITEM_QUANTITY = new Prefix("-q ");
    public static final Prefix PREFIX_ITEM_DESCRIPTION = new Prefix("-d ");
    public static final Prefix PREFIX_ITEM_LOCATION = new Prefix("-l ");

    // recipes start here
    public static final Prefix PREFIX_RECIPE_PRODUCT_NAME = new Prefix("-n ");
    public static final Prefix PREFIX_RECIPE_INGREDIENTS = new Prefix("-items ");
    public static final Prefix PREFIX_RECIPE_PRODUCT_QUANTITY = new Prefix("-pc ");
    public static final Prefix PREFIX_RECIPE_DESCRIPTION = new Prefix("-d ");

}
