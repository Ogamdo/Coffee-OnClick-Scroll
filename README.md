# Coffee Manual
![Android](https://img.shields.io/badge/Android-3DDC84?logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white)
![Figma](https://img.shields.io/badge/Figma-F24E1E?logo=figma&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white)<hr>


- It is a simple Android application that shows coffee menus.
---

## **Classes and Key Functions/Variables**

### **1. `MainActivity`**  
The main activity of the app, which initializes the RecyclerView and manages image click and drag-and-drop reordering functionality.

#### **Key Variables**
- **`LinkedHashMap<Integer, Boolean> imageClickStatus`**  
  Tracks the click status (`true`/`false`) of each image resource ID.

- **`RecyclerView recyclerView`**  
  Displays the list of drinks.

- **`ImageAdapter adapter`**  
  Binds data to the RecyclerView.

- **`String[] drinks`**  
  Stores the list of drink names.

- **`int[] images`**  
  Stores the corresponding image resource IDs for each drink.

---

#### **Key Functions**
- **`onCreate(Bundle savedInstanceState)`**  
  - Initializes the RecyclerView and adapter.
  - Sets up the drink names and `imageClickStatus`.
  - Implements drag-and-drop functionality via `ItemTouchHelper`.

- **`initializeImageClickStatus()`**  
  - Initializes the `LinkedHashMap` with image resource IDs and sets their initial click status to `false`.

- **`setupItemTouchHelper()`**  
  - Implements drag-and-drop reordering for RecyclerView items.
  - Updates the order of `drinks` and `images` arrays on drag events and refreshes the UI.

---

### **2. `ImageAdapter`**  
The adapter for the RecyclerView, responsible for binding drink names and images to the UI, and handling click events.

#### **Key Variables**
- **`String[] drinks`**  
  The list of drink names displayed in the RecyclerView.

- **`int[] imageList`**  
  The list of image resource IDs displayed in the RecyclerView.

- **`LinkedHashMap<Integer, Boolean> imageClickStatus`**  
  Tracks the click status of each image.

---

#### **Key Functions**
- **`ImageAdapter(String[] drinks, int[] imageList, LinkedHashMap<Integer, Boolean> imageClickStatus)`**  
  - Constructor that initializes drink names, images, and click statuses.

- **`onCreateViewHolder(ViewGroup parent, int viewType)`**  
  - Inflates the layout (`item.xml`) for each RecyclerView item.

- **`onBindViewHolder(ViewHolder holder, int position)`**  
  - Binds data to the UI components of each item.
  - Adjusts image size based on click status.
  - Handles image click events and updates the click status.

- **`getItemCount()`**  
  - Returns the number of items in the RecyclerView.

---

### **3. `OnItemClickListener` (Interface)**  
Handles click events for RecyclerView items.

#### **Key Function**
- **`onItemClick(int position)`**  
  - Triggered when an item is clicked, passing the position for further action.

---

### **4. Layout XML Files**

#### **`activity_main.xml`**
- **Components**:
  - `RecyclerView`: Displays the list of drinks.
  - `LinearLayout` or `RelativeLayout`: Defines the overall layout.

#### **`item.xml`**
- **Components**:
  - `ImageView`: Displays the drink image.
  - `TextView`: Displays the drink name.

---

## **How the Classes Interact**

1. **`MainActivity`**
   - Manages RecyclerView and `ImageAdapter`.
   - Initializes the drink data and click statuses via `LinkedHashMap`.
   - Handles drag-and-drop reordering through `ItemTouchHelper`.

2. **`ImageAdapter`**
   - Updates the UI for RecyclerView items.
   - Handles image click events and adjusts the image size dynamically.

3. **`OnItemClickListener`**  
   - (Optional) Handles additional item-specific actions like displaying detailed information.

---

This structured information is ready for creating a flow chart in Figma. You can use the following hierarchical layout in the flow chart:

1. Start with `MainActivity` at the top.
2. Show connections to `RecyclerView`, `ImageAdapter`, and `ItemTouchHelper`.
3. Highlight the interaction between `ImageAdapter` and its key functionalities (`onBindViewHolder`, `onCreateViewHolder`).
4. Link to layout XML components (`activity_main.xml`, `item.xml`).
5. Optionally, include `OnItemClickListener` for extended functionality.

Let me know if you'd like assistance designing the flow chart! 😊
