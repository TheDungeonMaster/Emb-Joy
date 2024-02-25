package com.example.pregnancyapp.aichat

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore.Images.Media.getBitmap
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.AddPhotoAlternate
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pregnancyapp.CustomBottomNavigationBar
import com.example.pregnancyapp.R
import com.example.pregnancyapp.ReusableIcon
//import coil.compose.AsyncImagePainter
//import coil.compose.rememberAsyncImagePainter
//import coil.request.ImageRequest
//import coil.size.Size
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainChatScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        //top bar color
        color = Color(0xff000000)
    ) {

        Scaffold(

            topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF1F1F1))
                        .height(130.dp)
                        .padding(start = 24.dp, end = 24.dp, top = 20.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReusableIcon(
                            iconResourceId = R.drawable.gemini_bot_logo,
                            iconSize = 100,
                            scaleSize = 1.2f,
                            bottomPadding = 10 // Adjust the bottom padding
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
                            verticalArrangement = Arrangement.Center // Center

                        // content vertically

                        ) {
                            ReusableIcon(
                                iconResourceId = R.drawable.gemini_text,
                                iconSize = 100,
                                scaleSize = 1.3f,
                                bottomPadding = 0
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                ReusableIcon(
                                    iconResourceId = R.drawable.bot_online_dot,
                                    iconSize = 24, // Adjust the size as needed
                                    scaleSize = 1.5f,
                                    bottomPadding = 0
                                )
                                ReusableIcon(
                                    iconResourceId = R.drawable.online_text_bot,
                                    iconSize = 100,
                                    scaleSize = 1.4f,
                                    bottomPadding = 0
                                )

                            }
                        }
                    }
                }


            },
            bottomBar = { CustomBottomNavigationBar(
                navController = navController, R.drawable
                    .union, R.drawable.bot_icon_active, R.drawable
                    .profile_nonactive, Modifier, Color.White
            )}
        ) {
            ChatScreen(paddingValues = it)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(paddingValues: PaddingValues) {
    val uriState = MutableStateFlow("")
    val chaViewModel = viewModel<ChatViewModel>()
    val chatState = chaViewModel.chatState.collectAsState().value

    val bitmap = getBitmap()


    Column(
        modifier = Modifier

            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding()),
        verticalArrangement = Arrangement.Bottom
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            reverseLayout = true
        ) {
            itemsIndexed(chatState.chatList) { index, chat ->
                if (chat.isFromUser) {
                    UserChatItem(
                        prompt = chat.prompt, bitmap = chat.bitmap
                    )
                } else {
                    ModelChatItem(response = chat.prompt)
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(8.dp))

            TextField(
                modifier = Modifier
                    .weight(1f),
                value = chatState.prompt,
                onValueChange = {
                    chaViewModel.onEvent(ChatUiEvent.UpdatePrompt(it))
                },
                placeholder = {
                    Text(text = "Type a prompt")
                },
                singleLine = true,

                keyboardActions = KeyboardActions(
                    onDone = {
                        chaViewModel.onEvent(ChatUiEvent.SendPrompt(chatState.prompt, bitmap))
                        uriState.update { "" }
                    }
                )

            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        chaViewModel.onEvent(
                            ChatUiEvent.SendPrompt(
                                chatState.prompt,
                                bitmap
                            )
                        )
                        uriState.update { "" }
                    },
                imageVector = Icons.Rounded.Send,
                contentDescription = "Send prompt",
                // color for send button
                tint = Color(0xff000000)
            )

        }
        Spacer(Modifier.height(60.dp))

    }

}

@Composable
fun UserChatItem(prompt: String, bitmap: Bitmap?) {
    Column(
        modifier = Modifier.padding(start = 100.dp, bottom = 16.dp)
    ) {

        bitmap?.let {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .padding(bottom = 2.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                bitmap = it.asImageBitmap()
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                // color for user sent message
                .background(Color(0xff63B8C3))
                .padding(16.dp),
            text = prompt,
            fontSize = 17.sp,

            color = Color(0xffffffff)
        )
    }
}

@Composable
fun ModelChatItem(response: String) {
    Column(
        modifier = Modifier.padding(end = 100.dp, bottom = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xffEEEEEE))
                .padding(16.dp),
            text = response,
            fontSize = 17.sp,
            color = Color(0xff505050)
        )

    }
}

@Composable
fun getBitmap(): Bitmap? {
    val uriState = MutableStateFlow("")
    val uri = uriState.collectAsState().value
    return null
}