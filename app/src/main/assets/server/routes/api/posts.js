const express = require('express');
const mongodb = require('mongodb');

const router = express.Router();


const uri = "mongodb+srv://marcos8370:Acer2016@cluster0.72glp.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
const client = new mongodb.MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });

router.get("/",async(req,res)=>{
    const posts = await loadPostsCollection();
    res.send(await posts.find({}).toArray());
    // res.send('hello');
})


//Listar todos os posts
async function loadPostsCollection(){
    await client.connect();
    return client.db('Veferoma').collection('Trashmap');
}


//Crar posts
router.post('/', async(req,res)=>{
    const posts = await loadPostsCollection();
   await posts.insertOne({
        ///Colocar aqui o jeito em JSON para criar um post
        //text: req.body.text
        text: "bem vindo",
        data: "12/05"
   });
   res.status(201).send();
})

//Apagar posts
router.delete('/:id', async(req,res)=>{
    const posts = await loadPostsCollection();
    await posts.deleteOne({
        _id:  new mongodb.ObjectID(req.params.id)
    });
    res.status(201).send();
})
module.exports = router;