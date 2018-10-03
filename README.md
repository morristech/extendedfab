### ExtendedFAB ###

A version of Android's Floating Action Button (FAB) that follows the FAB of Android Messages. 

[Original Bitbucket Repo](https://bitbucket.org/thenotoriousrog/extendedfab)

[Example of ExtendedFAB](https://drive.google.com/open?id=1Jgt9FKGpv-USEKpJ_V_DeYAxtwSVEYFM)

## Gradle & Maven ##

    implementation 'com.thenotoriousrog.thenotoriousrog:extendedfab:1.1.1' // always check for newer versions as this may not always be up-to-date.

OR
    
    <dependency>
        <groupId>com.thenotoriousrog.thenotoriousrog</groupId>
        <artifactId>extendedfab</artifactId>
        <version>1.1.0</version>
        <type>pom</type>
    </dependency>


## Usage ##

It's advised to create he view inside of along with the rest of your views. However, it's possible to programmatically create the ExtendedFAB.
    
    <extendedfablib.ExtendedFAB
            android:id="@+id/extendedFAB"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentEnd="true"
            android:layout_alignParentBottom="true"
            android:layout_marginEnd="16dp"
            android:layout_marginBottom="16dp"
            android:elevation="5dp"
            />

After you have set up the ExtendedFAB in the XML you will want to set an icon and label like so:

    ExtendedFAB fab = findViewById(R.id.extendedFAB);
    fab.setIcon(R.drawable.icon); // you will want to set a resource of some sort to put in the lib.
    fab.setLabel("Some label string");

You can also change the color of the label text and the background like so:
    
    fab.changeLabelColor(R.color.white);
    fab.changeBackgroundColor(R.color.blue);

The fab will shrink and extend based on scroll events of whatever AbsListView element you choose to use. In order to get this to work you'll need to create an ExtendedFABScrollListener and add that as a scroll listener to your ListView and pass in a reference to the current fab that your project is using. Like so:

    listview.setOnScrollListener(new ExtendedFABScrollListener(fab));

If you're using a RecyclerView this is the same concept except you'll want to use ExtendedFABRecyclerScrollListener pass in the ExtendedFAB you're using and add it as a scroll listener for your RecyclerView like so:

    recyclerView.addOnScrollListener(new ExtendedFABRecyclerScrollListener(fab));

## Note ##
Please ensure that you're using at least version 1.1.1 as RecyclerView scroll behavior will not work on previous versions!

You may also see a demo of how to use this lib in the demo application. There are examples of both ListView and RecyclerView implementations.

## Known Issues ##
None. At least, none that I'm aware of. If you happen to find any please add it as an issue on the repo so that either I, or another kind dev can fix it! Many thanks, I hope this lib gives your app that extra little nudge you're looking for!