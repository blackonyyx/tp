package seedu.address.ui;

import java.util.List;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.Inventory;
import seedu.address.model.item.Item;
import seedu.address.model.recipe.Recipe;


/**
 * Panel containing the list of inventory.
 */
public class InventoryListPanel extends UiPart<Region> {
    private static final String FXML = "InventoryListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(InventoryListPanel.class);

    @FXML
    private ListView<Inventory> itemListView;

    private View.InventoryType inventoryType;

    /**
     * Creates a {@code InventoryListPanel} with the given {@code ObservableList}.
     */
    public InventoryListPanel(List<Inventory> inventoryList, View.InventoryType inventoryType) {
        super(FXML);
        this.inventoryType = inventoryType;
        ObservableList<Inventory> observableInventoryList = FXCollections.observableList(inventoryList);
        itemListView.setItems(observableInventoryList);
        itemListView.setCellFactory(listView -> new ItemListViewCell());
    }

    public void refresh(List<Inventory> inventoryList, View.InventoryType inventoryType) {
        this.inventoryType = inventoryType;
        ObservableList<Inventory> observableInventoryList = FXCollections.observableList(inventoryList);
        itemListView.setItems(observableInventoryList);
        itemListView.setCellFactory(listView -> new ItemListViewCell());
    }

    public View.InventoryType getInventoryType() {
        return this.inventoryType;
    }
    public void setInventoryType(View.InventoryType inventoryType) {
        this.inventoryType = inventoryType;
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Item} using a {@code InventoryCard}.
     */
    class ItemListViewCell extends ListCell<Inventory> {

        @Override
        protected void updateItem(Inventory inventory, boolean empty) {
            super.updateItem(inventory, empty);

            if (empty || inventory == null) {
                setGraphic(null);
                setText(null);
            } else {
                switch (inventory.getType()) {
                case ITEMS:
                    setGraphic(new InventoryCard((Item) inventory, getIndex() + 1).getRoot());
                    break;
                case RECIPES:
                    setGraphic(new RecipeCard((Recipe) inventory, getIndex() + 1).getRoot());
                    break;
                default:
                    throw new IllegalStateException("This inventoryType is not valid" + inventoryType);
                }
            }
        }
    }
}