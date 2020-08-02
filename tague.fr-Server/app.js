const express = require('express')
const { json } = require('express')
const app = express()
const mongoClient = require('mongodb').MongoClient
const url = "mongodb://localhost:27017"

app.use(express.json())

mongoClient.connect(url, (err, db) =>{
    if(err){
        console.log('error while connecting to database')
    } else{
        const mydb = db.db('TagueFr')
        const itemCollection = mydb.collection('ItemCollection')
        console.log('table crée')

        app.post('/item', (req, res) => {
            const query = {
                titre: "TITRE TEST MONGO"
            }
            itemCollection.findOne(query, (err, result) => {
                
                const obj = {
                    titre: result.titre,
                    source: result.source,
                    date: result.date
                }
                console.log(obj.source)
                if(result != null){
                    res.status(200).send(JSON.stringify(obj))
                }
            })
        })
    }
})
app.listen(3000, () => {
    console.log('listening on port 3000')
})