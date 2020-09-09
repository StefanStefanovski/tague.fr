const express = require("express");
const { json } = require("express");
const app = express();
const mongoClient = require("mongodb").MongoClient;
const url = "mongodb://92.222.78.212:27017";
//const url = "mongodb://localhost:27017"

app.use(express.json());

mongoClient.connect(url, (err, db) => {
  if (err) {
    console.log("error while connecting to database");
  } else {
    const mydb = db.db("france");
    mydb.listCollections().toArray(function (error, collInfo) {
      if (error) {
        console.log(error);
      } else {
        console.log(collInfo);
      }
    }); /*
        const itemCollection = mydb.collection('ItemCollection')
        console.log('table crée')

        app.post('/item', (req, res) => {

            var resultArray = []
            var cursor = itemCollection.find();
            cursor.forEach(function(doc,error) {
                if(error != null){
                    res.status(404).send()
                    console.log(error)
                } else {
                     resultArray.push(doc);
                     const obj = {
                         titre: doc.titre,
                         source: doc.source,
                         date: doc.date
                     }
                     console.log(doc)

                }
            }, function() {
                const toSend = {
                    data: resultArray
                }
                res.status(200).send(JSON.stringify(toSend))
                console.log("Rsult Array : \n", toSend)

            })
            

            const query = {
            }
            itemCollection.find(query, (err, result) => {
            
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
        })*/
  }
});
app.listen(3000, () => {
  console.log("listening on port 3000");
});
