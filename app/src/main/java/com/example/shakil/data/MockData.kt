package com.example.shakil.data

import com.example.shakil.model.Post
import com.example.shakil.model.Story
import com.example.shakil.model.User

object MockData {
    val stories = java.util.ArrayList<Story>()
    val users = java.util.ArrayList<User>()
    val posts = java.util.ArrayList<Post>()
    init {

        users.add(User("Sina.M" , "https://img.freepik.com/free-photo/waist-up-portrait-handsome-serious-unshaven-male-keeps-hands-together-dressed-dark-blue-shirt-has-talk-with-interlocutor-stands-against-white-wall-self-confident-man-freelancer_273609-16320.jpg?w=996&t=st=1660752984~exp=1660753584~hmac=96aadf36c237aef691556424fd2d5cf8c37a6089f0b4b6bc8c7384708963c4d8" ,  "Sina Moradi"))
        users.add(User("M.Jafari" , "https://img.freepik.com/free-photo/playing-violin_1150-8374.jpg?w=900&t=st=1660757354~exp=1660757954~hmac=a8c731881bef3e1d2d3ce57eaa326208f97d6b5fbcd262c38808c248f944c814"   , "Mostafa Jafari"))
        users.add(User("Lucy Baker" , "https://img.freepik.com/free-photo/side-view-child-standing-karate-stance-studio_7502-4359.jpg?w=996&t=st=1660757403~exp=1660758003~hmac=16e95d5db2c220b55891588f6c89e7c1c161fa6fa1060833cc2480959fbf692a"   , "Lucy Baker"))
        users.add(User("Timmy Jon" , "https://img.freepik.com/free-photo/confident-young-handsome-cook-chef-uniform-standing-white-wall-isolated-orange-wall-with-copy-space_141793-101130.jpg?w=996&t=st=1660757468~exp=1660758068~hmac=79e7d221a4d7528031520e3152e1e6e077eb4385b959857ccde3c692ec319dfb"  , "Timmy Jon"))
        users.add(User("Brayan wick" , "https://img.freepik.com/free-photo/portrait-young-motivated-carpenter-standing-by-woodworking-machine-his-carpentry-workshop_342744-823.jpg?w=996&t=st=1660757542~exp=1660758142~hmac=f8ac3ce2caf87ffdd6ead77a5178be8f2b38c98e5b6802d5b7c5340258b13c46"   , "Brayan wick"))
        users.add(User("Error User" , ""   , "Error User"))
        users.add(User("Aslan sori" , "https://img.freepik.com/free-photo/mechanic-with-spanners-pockets_1170-1502.jpg?w=996&t=st=1660757503~exp=1660758103~hmac=fa5ddf8dab7239be1895841dec9b2bef9cd32cdca8cf07d4e2a2b2850bfa5885" , "Aslan sori"))


        stories.add(Story(users[0], users[0].profileImage ,  true))
        stories.add(Story(users[1], users[1].profileImage ,false))
        stories.add(Story(users[2], users[2].profileImage ,false))
        stories.add(Story(users[3], users[3].profileImage ,false))
        stories.add(Story(users[4], users[4].profileImage ,false))
        stories.add(Story(users[5], users[5].profileImage ,false))
        stories.add(Story(users[6], users[5].profileImage ,false))



        posts.add(Post(users[0] , users[0].profileImage , " Hey guys , this page is created to show you how to speak correctly in sessions. Follow page and videos to be notified." ,"Iran Gillan"  ))
        posts.add(Post(users[1] ,  users[1].profileImage , " Wanna learn how to play a violin? Ok this page is for you! " , "Iran Shiraz" ))
        posts.add(Post(users[2] ,  users[2].profileImage , "\"There’s much more to life than dyin’ over your past mistakes and people who threw dirt on your name.\" — Lil Nas X, \"Sun Goes Down\"" ,  "America California" ))
        posts.add(Post(users[3] ,  users[3].profileImage, "\"Lightning strikes every time she moves.\" — Calvin Harris, \"This Is What You Came For\"" , "Canada Toronto"  ))
        posts.add(Post(users[4] ,  users[4].profileImage , "“Life without dreaming is a life without meaning.” – Wale, “Aston Martin Music”" , "England London" ))
        posts.add(Post(users[5] ,  "" , "" , "Iran Hamedan"  ))
        posts.add(Post(users[6] ,  users[6].profileImage , "\"I'm on the pursuit of happiness and I know everything that shine ain't always gonna be gold, hey, I'll be fine once I get it, yeah, I'll be good.\" — Kid Cudi, \"Pursuit of Happiness (Nightmare)\"" , "Iran Hamedan"  ))


}
}
