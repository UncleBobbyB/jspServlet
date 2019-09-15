/*
Use .fetch() to load in new html snippets. A function then removes the old HTML and adds
the new ones in the correct position in the DOM. Animate the whole thing in and out.
*/

let homeLink = document.getElementById("Home-link");
let productsLink = document.querySelector("#Products-link");
let experienceLink = document.querySelector("#Experience-link");
let teamLink = document.querySelector("#Team-link");
let contactLink = document.querySelector("#Contact-link");

let linkArray = [homeLink, productsLink, experienceLink, teamLink, contactLink];

linkArray.forEach((eachLink) => {
	eachLink.addEventListener('click', (e) => {
		switch (eachLink) {
			case homeLink:
				fetchPage(eachLink, 'index.html');
				break;

			case productsLink:
				fetchPage(eachLink, 'shop.html');
				break;

			case experienceLink:
				fetchPage(eachLink, 'experience.html');
				break;

			case teamLink:
				fetchPage(eachLink, 'team.html');
				break;

			case contactLink:
				fetchPage(eachlink, 'contact.html');
		}
	})
})

function fetchPage(link, page) {
	let baseURL = `${window.location.protocol}//${window.location.hostname}`;
	console.log(baseURL);
	let homeURL = 'e-commerce';

	if (window.location.port) {
		baseURL += `:${window.location.port}`;
	}

	fetch(`${baseURL}/${homeURL}/${page}`)
		.then(function(response) {
			return response.text()
		})
		.then(function(html) {
			let doc = new DOMParser().parseFromString(html, "text/html");

			anime({
				targets: '.text-section h1, .text-section p, .text-section div',
				translateX: 700,
				opacity: 0,
				easing: 'easeInExpo',
				duration: 700,
				complete: (anim) => {
					document.querySelector('.column-wrapper').remove();
				}
			})

			setTimeout(function () {
				document.querySelector('body').insertBefore(doc.querySelector('.new-content'), document.querySelector('.gallery-nav'));

				anime({
					targets: '.new-content .text-section h1, .new-content .text-section p, .new-content .text-section div',
					translateX: [-600, 0],
					delay: (el, i) => 100 * i,
					opacity: [0, 1],
					easing: 'easeOutExpo',
				})
			}, 700);
		})
}
