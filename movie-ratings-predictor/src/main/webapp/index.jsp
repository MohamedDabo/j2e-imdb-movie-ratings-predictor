<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
  	<div class="container" style="margin-top:50px;">
  		<div class="row">
  			<div class="col-md-8 offset-md-2">
  				<h1>Movie Rating Predictor!</h1>
			    <form action="rating" method="post">
				  <div class="form-group">
				    <label>Title</label>
				    <input class="form-control" name="title" placeholder="Ex: The Lion King" required>
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">Genres</label>
				    <small class="form-text text-muted">Select all that apply.</small>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Action">
					  <label class="form-check-label">Action</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Adventure">
					  <label class="form-check-label">Adventure</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Horror">
					  <label class="form-check-label">Horror</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox"  name="genres" value="Romance">
					  <label class="form-check-label">Romance</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="War">
					  <label class="form-check-label">War</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="History">
					  <label class="form-check-label">History</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Western">
					  <label class="form-check-label">Western</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Sci-Fi">
					  <label class="form-check-label">Sci-Fi</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Sport">
					  <label class="form-check-label">Sport</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Drama">
					  <label class="form-check-label">Drama</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Thriller">
					  <label class="form-check-label">Thriller</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Music">
					  <label class="form-check-label">Music</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Crime">
					  <label class="form-check-label">Crime</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Biography">
					  <label class="form-check-label">Biography</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Fantasy">
					  <label class="form-check-label">Fantasy</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Animation">
					  <label class="form-check-label">Animation</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Western">
					  <label class="form-check-label">Western</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Family">
					  <label class="form-check-label">Family</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Mystery">
					  <label class="form-check-label">Mystery</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Comedy">
					  <label class="form-check-label">Comedy</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="genres" value="Musical">
					  <label class="form-check-label">Musical</label>
					</div>
				  </div>
				  
				  <div class="row">
				    <div class="col">
				      <label>Directors</label>
				      <input type="text" class="form-control" name="directors" placeholder="Ex: John Doe, Jane Doe" required>
				    </div>
				    <div class="col">
				      <label>Duration</label>
				      <input type="text" class="form-control" name="duration" pattern="[0-9]{1,3}" placeholder="Ex: 181 (in minutes)" required>
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col">
				      <label>Revenue</label>
				      <input type="text" class="form-control" name="revenue" pattern="[0-9]{1,3}" placeholder="Ex: 234 (for 234 millions)" required>
				    </div>
				    <div class="col">
			    	  <label>Value of K</label>
				      <input type="text" class="form-control" name="k_neighbors" pattern="[0-9]{1,2}" placeholder="Ex: 2 (for 2 nearest neighbors)">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label>Actors</label>
				    <textarea class="form-control" rows="3" name="actors" required></textarea>
				  </div>
				  
				  <button type="submit" class="btn btn-primary">Submit</button>
				</form>
  			</div>
  		</div>
  	</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>
