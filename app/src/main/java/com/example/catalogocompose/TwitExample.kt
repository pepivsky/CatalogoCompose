package com.example.catalogocompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment


//#181F2C

@Preview(showBackground = true)
@Composable
fun Tweet() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF181F2C))
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFF181F2C))
                .padding(16.dp)
        ) {

            Row(Modifier.fillMaxWidth()) {
                ProfileIcon()
                Spacer(modifier = Modifier.size(16.dp))
                Column {
                    Twittheader()
                    TwittContent()
                    Spacer(modifier = Modifier.size(16.dp))
                    TwittImage()
                    Spacer(modifier = Modifier.size(16.dp))
                    TwittSocialButtons()

                }
            }

        }

        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)
    }
}


@Composable
fun ProfileIcon() {
    Image(
        modifier = Modifier
            .size(46.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "profile icon"
    )
}

@Composable
fun Twittheader() {
    Row() {
        Text(text = "Aris", color = Color.White, fontWeight = FontWeight.Bold)
        Text(text = "@AristiDevs 4h", color = Color.Gray)
        Spacer(modifier = Modifier.weight(1F))
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "options button",
            tint = Color.White
        )
    }
}

@Composable
fun TwittContent() {
    //Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ", color = Color.White)
    Text(text = stringResource(id = R.string.saludo), color = Color.White)
}

@Composable
fun TwittImage() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp)),
        painter = painterResource(id = R.drawable.profile),
        contentScale = ContentScale.Crop,
        contentDescription = "twittImage"
    )
}

@Composable
fun TwittSocialButtons() {
    var chatClicked by rememberSaveable { mutableStateOf(false) }
    var rtClicked by rememberSaveable { mutableStateOf(false) }
    var likeClicked by rememberSaveable { mutableStateOf(false) }

    var commentCounter by rememberSaveable { mutableStateOf(1) }
    var rtCounter by rememberSaveable { mutableStateOf(1) }
    var likeCounter by rememberSaveable { mutableStateOf(1) }



    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(modifier = Modifier.size(24.dp), onClick = {
            chatClicked = !chatClicked
            if (chatClicked) commentCounter++ else commentCounter--
        }) {
            val icChatFilled = R.drawable.ic_chat_filled
            val icChatNormal = R.drawable.ic_chat
            Icon(
                painter = painterResource(id = if (chatClicked) icChatFilled else icChatNormal),
                contentDescription = "icon chat",
                tint = Color.Gray
            )
        }
        Text(text = commentCounter.toString(), color = Color.Gray)
        Spacer(modifier = Modifier.weight(1F))

        IconButton(modifier = Modifier.size(24.dp), onClick = {
            rtClicked = !rtClicked
            if (rtClicked) rtCounter++ else rtCounter--
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "icon chat",
                tint = if (rtClicked) Color.Green else Color.Gray
            )
        }
        Text(text = rtCounter.toString(), color = Color.Gray)
        Spacer(modifier = Modifier.weight(1F))


        IconButton(modifier = Modifier.size(24.dp), onClick = {
            likeClicked = !likeClicked
            if (likeClicked) likeCounter++ else likeCounter--
        }) {
            val likeNormal = R.drawable.ic_like
            val likeFilled = R.drawable.ic_like_filled
            Icon(
                painter = painterResource(id = if (likeClicked) likeFilled else likeNormal),
                contentDescription = "icon chat",
                tint = if (likeClicked) Color.Red else Color.Gray
            )
        }
        Text(text = likeCounter.toString(), color = Color.Gray)
        Spacer(modifier = Modifier.weight(1F))


    }
}