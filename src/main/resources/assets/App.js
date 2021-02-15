import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        XMeme
      </header>
      <form id="my-form" onSubmit={myFunction}>
        <label class="label">Meme Owner</label><br/>
        <input type="text" id="meme-owner" class="text-input" placeholder="Enter your name" /><br/>

        <label class="label">Caption</label><br/>
        <input type="text" id="meme-caption" class="text-input" placeholder="Be creative with caption" /><br/>

        <label class="label">Meme URL</label><br/>
        <input type="text" id="meme-url" class="text-input" placeholder="Enter Meme Url" /><br/>

        <input type="submit" id="submit-meme" value="Post Meme" />
      </form>

      <div id="meme-gallery">
        
      </div>
      
    </div>
    
  );
  
}

function myFunction() {
    document.getElementById('my-form').action = "http://localhost:8080/memes";
    alert("The form was submitted");
}

export default App;
