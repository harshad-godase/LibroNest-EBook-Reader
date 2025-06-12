package com.example.ebooklibrary.presentation.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ebooklibrary.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController) {


    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val urlHandler = LocalUriHandler.current
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(250.dp)
                        .padding(16.dp)
                ){


                    Spacer(modifier = Modifier.height(16.dp))
                    Divider()
                    NavigationDrawerItem(
                        label ={ Text("Home") },
                        selected = true,
                        icon = {Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")},
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        }
                    )

                    Divider()
                    NavigationDrawerItem(
                        label = {Text("Version 1.0")},
                        selected = false,
                        icon = {Icon(imageVector = Icons.Filled.Info, contentDescription = "Version")},
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            Toast.makeText(context, "Version 1.0", Toast.LENGTH_SHORT).show()
                        }
                    )

                    Divider()
                    NavigationDrawerItem(
                        label = {Text("Contact Me")},
                        selected = false,
                        icon = {Icon(imageVector = Icons.AutoMirrored.Filled.Message, contentDescription = "Contact Me")
                               },
                        onClick = {
                            urlHandler.openUri("https://www.linkedin.com/in/harshad-godase/")
                        }
                    )

                    Divider()
                    NavigationDrawerItem(
                        label = {Text("Source Code")},
                        selected = false,
                        icon = {Icon(
                            painterResource(id = R.drawable.githubwhite),
                            contentDescription = "github",
                            modifier = Modifier.size(24.dp))

                        },
                        onClick = {
                            urlHandler.openUri("https://github.com/harshad-godase")
                        }
                    )

                    Divider()
                    NavigationDrawerItem(
                        label = {Text("Bug Report")},
                        selected = false,
                        icon = {Icon(
                            painterResource(id = R.drawable.bug),
                            contentDescription = "Report",
                            modifier = Modifier.size(24.dp))

                        },
                        onClick = {
                            urlHandler.openUri("https://github.com/harshad-godase/Ebook-Library-App")
                        }
                    )






                }
            }


        }
    ) {

        Scaffold (
            modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Row (verticalAlignment = Alignment.CenterVertically){

                            Spacer(modifier = Modifier.width(8.dp))

                            Text("Book Library",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                                )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "open drawer")
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }

        ){
            innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding).fillMaxSize()
            ) {
                TabScreen(navHostController=navHostController)
            }

        }


    }

}